package com.personal.expenses.domain.service;

import com.personal.expenses.domain.exception.ResourceBadRequestException;
import com.personal.expenses.domain.exception.ResourceNotFoundException;
import com.personal.expenses.domain.model.User;
import com.personal.expenses.domain.repository.UserRepository;
import com.personal.expenses.dto.user.UserRequestDto;
import com.personal.expenses.dto.user.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserService implements InterfaceCrudService<UserRequestDto, UserResponseDto> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UserResponseDto> getAll() {
        List<User> users = userRepository.findAll();

        /* List<UserResponseDto> userDto = new ArrayList<>();
        for(User user : users){
            UserResponseDto dto = mapper.map(user, UserResponseDto.class);
            userDto.add(dto);
            //userDto.add(mapper.map(user, UserResponseDto.class));
        }

        return userDto; */

        return users.stream()
                .map(user -> mapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getById(Long id) {
        Optional<User> optUser = userRepository.findById(id);

        if(optUser.isEmpty()){
            throw new ResourceNotFoundException("Nao foi possivel encontrar o usuario com esse id: " + id);
        }

        return mapper.map(optUser.get(), UserResponseDto.class);
    }

    @Override
    public UserResponseDto register(UserRequestDto dto) {
        validateUser(dto);

        Optional<User> optUser = userRepository.findByEmail(dto.getEmail());

        if(optUser.isPresent()){
            throw new ResourceBadRequestException("Já existe um usuario com esse e-mail: " + dto.getEmail());
        }

        User user = mapper.map(dto, User.class);

        user.setId(null);
        user.setRegisterDate(new Date());
        user = userRepository.save(user);
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto dto) {
        UserResponseDto userDatabase = getById(id);

        validateUser(dto);

        User user = mapper.map(dto, User.class);

        user.setId(id);
        user.setInactivationDate(userDatabase.getInactivationDate());
        user.setRegisterDate(userDatabase.getRegisterDate());
        user = userRepository.save(user);
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        Optional<User> optUser = userRepository.findById(id);

        if(optUser.isEmpty()){
            throw new ResourceNotFoundException("Nao foi possivel encontrar o usuario com esse id: " + id);
        }

        User user = optUser.get();

        user.setInactivationDate(new Date());
        userRepository.save(user);
    }

    public void validateUser(UserRequestDto dto){
        if(dto.getEmail() == null || dto.getPassword() == null){
            throw new ResourceBadRequestException("Email e senha são obrigatorios");
        }
    }
}

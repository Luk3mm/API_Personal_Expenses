package com.personal.expenses.domain.service;

import com.personal.expenses.domain.model.User;
import com.personal.expenses.domain.repository.UserRepository;
import com.personal.expenses.dto.user.UserRequestDto;
import com.personal.expenses.dto.user.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        }

        return mapper.map(optUser.get(), UserResponseDto.class);
    }

    @Override
    public UserResponseDto register(UserRequestDto dto) {
        return null;
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

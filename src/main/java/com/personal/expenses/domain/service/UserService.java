package com.personal.expenses.domain.service;

import com.personal.expenses.domain.repository.UserRepository;
import com.personal.expenses.dto.user.UserRequestDto;
import com.personal.expenses.dto.user.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements InterfaceCrudService<UserRequestDto, UserResponseDto> {
    @Autowired
    private UserRepository userRepository;

    private ModelMapper mapper;

    @Override
    public List<UserResponseDto> getAll() {
        return null;
    }

    @Override
    public UserResponseDto getById(Long id) {
        return null;
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

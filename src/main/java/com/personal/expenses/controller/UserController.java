package com.personal.expenses.controller;

import com.personal.expenses.domain.service.UserService;
import com.personal.expenses.dto.user.UserRequestDto;
import com.personal.expenses.dto.user.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }
    @PostMapping
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto dto){
        UserResponseDto user = userService.register(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id,@RequestBody UserRequestDto dto){
        UserResponseDto user = userService.update(id, dto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.info.teknik.controller;

import com.info.teknik.dto.UserDto;
import com.info.teknik.entity.User;
import com.info.teknik.service.AuthService;
import com.info.teknik.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("api/user")
@RestController
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return userService.getAll();
    }

    @GetMapping("auth")
    public ResponseEntity<UserDto> getAuthUser() {
        return ResponseEntity.ok(authService.getAuthUser());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }
}

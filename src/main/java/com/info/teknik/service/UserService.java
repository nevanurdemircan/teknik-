package com.info.teknik.service;

import com.info.teknik.converter.UserConverter;
import com.info.teknik.dto.UserDto;
import com.info.teknik.entity.User;
import com.info.teknik.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final UserConverter converter;

    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> userDtos = userRepository.findAll().stream().map(converter::convertToUserDto).toList();
        return ResponseEntity.ok(userDtos);
    }

    public ResponseEntity<Void> update(UUID id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));

        user.setPhone(userDto.getPhone());
        user.setName(userDto.getName());
        user.setMail(user.getMail());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}

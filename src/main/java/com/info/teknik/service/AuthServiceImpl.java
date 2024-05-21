package com.info.teknik.service;

import com.info.teknik.converter.UserConverter;
import com.info.teknik.dto.SignUpRequest;
import com.info.teknik.dto.UserDto;
import com.info.teknik.entity.User;
import com.info.teknik.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserConverter converter;

    @Override
    public UserDto createUser(SignUpRequest signUpRequest) {
        User user = converter.SignUpRequestConvertToUser(signUpRequest);
        User savedUser = userRepository.save(user);

        UserDto savedUserDto = converter.convertToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getAuthUser() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findFirstByMail(principal.getUsername());
        UserDto userDto = converter.convertToUserDto(user);
        return userDto;
    }
}


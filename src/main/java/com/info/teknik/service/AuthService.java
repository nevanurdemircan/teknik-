package com.info.teknik.service;

import com.info.teknik.dto.SignUpRequest;
import com.info.teknik.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignUpRequest signUpRequest);

    UserDto getAuthUser();
}

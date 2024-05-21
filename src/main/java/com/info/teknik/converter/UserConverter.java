package com.info.teknik.converter;

import com.info.teknik.dto.SignUpRequest;
import com.info.teknik.dto.UserDto;
import com.info.teknik.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto convertToUserDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setMail(user.getMail());
        dto.setPhone(user.getPhone());
        dto.setLastName(user.getLastName());
        return dto;
    }
    public User SignUpRequestConvertToUser(SignUpRequest signUpRequest){
       User user = new User();
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        user.setName(signUpRequest.getName());
        user.setMail(signUpRequest.getMail());
        user.setLastName(signUpRequest.getLastName());
        user.setPhone(signUpRequest.getPhone());
        return user;
    }
}

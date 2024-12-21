package com.lol_park;

import com.lol_park.User;
import com.lol_park.User_DTO;
import com.lol_park.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasswordValidator passwordvalid;

    public String create(@RequestBody User_DTO userDto) {

        if(!passwordvalid.validate(userDto.getPassword1(),userDto.getPassword2())){
            return "Passwords do not match";

        }
        User user = userDto.toEntity(passwordEncoder.encode(userDto.getPassword1()));
        userJpaRepository.save(user);
        return "User registered successfully";
    }



}

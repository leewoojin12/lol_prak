package com.lol_park;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User_DTO {
    private String name;


    private String nickname;

    private String password1;

    private String password2;

    public User toEntity(String encodedPassword) {
        User user = new User();
        user.setNickname(this.nickname);
        user.setPassword(encodedPassword);
        user.setName(this.name);
        user.setRoles(Set.of("USER")); // 기본적으로 사용자에게 ROLE_USER 부여
        return user;
    }





}
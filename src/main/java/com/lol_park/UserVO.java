package com.lol_park;


import lombok.Getter;

import java.util.Objects;
@Getter

public class UserVO {
    private final String name;
    private final String email;

    // 생성자
    public UserVO(String name, String email) {
        if (name == null || email == null || name.isEmpty() || email.isEmpty()) {
            throw new IllegalArgumentException("Name and email cannot be null or empty");
        }
        this.name = name;
        this.email = email;
    }


    // equals()와 hashCode()를 오버라이드해서 두 VO를 비교할 때 값으로 비교
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return name.equals(userVO.name) && email.equals(userVO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
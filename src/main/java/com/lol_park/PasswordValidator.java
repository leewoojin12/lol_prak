package com.lol_park;


import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {


    public boolean validate(String password1, String password2) {
        if (password1 == null || password2 == null) {
            return false;
        }
        return password1.equals(password2);
    }
}

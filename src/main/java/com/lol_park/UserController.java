package com.lol_park;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {



    private final UserService userService;
    @GetMapping("/login")
    public String login() {




        return "login";
    }




    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User_DTO userdto ) {
        userService.create(userdto);



        return ResponseEntity.ok("성공");
    }

}

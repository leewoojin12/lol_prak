package com.lol_park;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {



    private final UserService userService;




    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        System.out.println(username + "@@@@@" + password);


        return "redirect:/";
    }





    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User_DTO userdto ) {
        userService.create(userdto);
        return ResponseEntity.ok("회원가입 성공");

    }

}

package com.lol_park;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter

public class User {


    @Id
    @GeneratedValue
    @Column(name = "User_id")
    private Long id;


    private String name;

    @Column(unique = true)
    private String nickname;


    private String password;


    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;


    public String getUsername() {
        return nickname; // nickname을 username으로 처리
    }
    //카드 번호??

    //




}

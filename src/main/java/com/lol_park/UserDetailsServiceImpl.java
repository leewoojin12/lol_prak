package com.lol_park;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;



    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        return userJpaRepository.findByNickname(nickname)
                .map(user -> User.builder()
                        .username(user.getNickname())
                        .password(user.getPassword())
                        .roles(user.getRoles().toArray(new String[0]))
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}

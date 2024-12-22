package com.lol_park;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository  extends JpaRepository<User, Long> {

    Optional<User> findByNickname(String nickname);

    Boolean existsByNickname(String Nickname);




}

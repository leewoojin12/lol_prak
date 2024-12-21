package com.lol_park;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository  extends JpaRepository<User, Long> {

    Optional<User> findByNickname(String nickname);




}

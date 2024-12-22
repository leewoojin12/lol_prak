package com.lol_park;

import com.lol_park.exception.NicknameAlreadyExistsException;
import com.lol_park.exception.InvalidPasswordException;
import com.lol_park.exception.PasswordMismatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(User_DTO userDto) {



        if (userDto.getNickname() == null || userJpaRepository.existsByNickname(userDto.getNickname())) {
            throw new NicknameAlreadyExistsException(userDto.getNickname() == null ? "닉네임 칸 비었음" : "이미 존재하는 닉네임.");
        }

        // 비밀번호 요구사항 체크
        if (userDto.getPassword1().length() < 6) {
            throw new InvalidPasswordException("비밀번호는 6자 이상이어야 합니다.");
        }

        if (!userDto.getPassword1().equals(userDto.getPassword2())) {
            throw new PasswordMismatchException("비밀 번호가 다릅니다.");

        }

        // User 객체 생성 후 암호화된 비밀번호 저장
        User user = userDto.toEntity(passwordEncoder.encode(userDto.getPassword1()));
        userJpaRepository.save(user);

    }






}

package com.jbini.Booklog.service;

import com.jbini.Booklog.exception.BaseException;
import com.jbini.Booklog.exception.BaseResponseCode;
import com.jbini.Booklog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public boolean existsByUserEmail(String email) {
        return userRepository.existsByUserEmail(email).orElseThrow(() -> new BaseException(BaseResponseCode.DUPLICATE_EMAIL));
    }
}

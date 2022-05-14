package com.jbini.Booklog.service;

import com.jbini.Booklog.dto.UserRequestDto;
import com.jbini.Booklog.dto.UserResponseDto;
import com.jbini.Booklog.dto.UserSignupRequestDto;
import com.jbini.Booklog.entity.User;
import com.jbini.Booklog.exception.BaseException;
import com.jbini.Booklog.exception.BaseResponseCode;
import com.jbini.Booklog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public boolean existsByUserEmail(String email) {
        return userRepository.existsByUserEmail(email).orElseThrow(() -> new BaseException(BaseResponseCode.DUPLICATE_EMAIL));
    }


    @Transactional(readOnly = true)
    public UserResponseDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public UserResponseDto findUserByEmail(String email) {
        User user = userRepository.findByUserEmail(email).orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Long signUp(UserSignupRequestDto userSignupRequestDto) throws BaseException {
        userRepository.existsByUserEmail(userSignupRequestDto.getUserEmail()).orElseThrow(() -> new BaseException(BaseResponseCode.DUPLICATE_EMAIL));
        userSignupRequestDto.setUserPassword(passwordEncoder.encode(userSignupRequestDto.getUserPassword()));
        try {
            userRepository.save(userSignupRequestDto.toEntity());
        } catch (Exception e) {
            throw new BaseException(BaseResponseCode.FAILED_TO_SAVE_USER);
        }
        return userRepository.findByUserEmail(userSignupRequestDto.getUserEmail()).get().getUserId();
    }
    public Optional<User> update(UserRequestDto userRequestDto) throws BaseException {
        Optional<User> user = userRepository.findByUserEmail(userRequestDto.getUserEmail());
        try {
            user.ifPresent(selectUser -> {
                selectUser.setUserNickname(userRequestDto.getUserNickname());
//                selectUser.setUserFilename(userRequestDto.getUserFilename());
                userRepository.save(selectUser);
            });
        } catch (Exception e) {
            throw new BaseException(BaseResponseCode.METHOD_NOT_ALLOWED);
        }
        return user;
    }

    public Long create(UserRequestDto userRequestDto) throws BaseException{
        try {
            User user = userRequestDto.toEntity();
            userRepository.save(user);
        } catch (Exception e) {
            throw new BaseException(BaseResponseCode.FAILED_TO_SAVE_USER);
        }
        return userRepository.findByUserEmail(userRequestDto.getUserEmail()).get().getUserId();
    }

    public Long delete(Long id) throws BaseException {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new BaseException(BaseResponseCode.USER_NOT_FOUND);
        }
        return id;
    }


    public User getUserByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail).orElseThrow(()-> new BaseException(BaseResponseCode.USER_NOT_FOUND));
    }
}

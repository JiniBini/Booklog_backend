package com.jbini.Booklog.dto;

import com.jbini.Booklog.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private final Long userId;
    private final String userEmail;
    private final String userName;
    private final String userNickname;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.userEmail = user.getUserEmail();
        this.userName = user.getUserName();
        this.userNickname = user.getUserNickname();
    }
}

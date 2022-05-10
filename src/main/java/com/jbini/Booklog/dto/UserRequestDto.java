package com.jbini.Booklog.dto;

import com.jbini.Booklog.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {

    private Long userId;
    private String userName;
    private String userNickname;

    @Builder
    public UserRequestDto(Long userId, String userName, String userNickname){
        this.userId = userId;
        this.userName = userName;
        this.userNickname = userNickname;
    }
    // dto -> entity
    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userName(userName)
                .userNickname(userNickname)
                .build();
    }
}

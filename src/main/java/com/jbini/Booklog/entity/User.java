package com.jbini.Booklog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@ApiModel(value = "회원 정보", description = "아이디, 이메일, 비밀번호 등 회원 정보를 가진 Class")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseTimeEntity {

    @ApiModelProperty(value = "아이디")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @ApiModelProperty(value = "이메일")
    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @ApiModelProperty(value = "비밀번호")
    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @ApiModelProperty(value = "이름")
    @Column(name = "user_name", nullable = false)
    private String userName;

    @ApiModelProperty(value = "별명")
    @Column(name = "user_nickname", nullable = false)
    private String userNickname;

    @ApiModelProperty(value = "프로필 파일명")
    @Column(name = "user_filename")
    private String userFilename;


    @Builder
    public User(String userEmail, String userName, String userPassword, String userNickname, String userFilename) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.userFilename = userFilename;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public void setUserFilename(String userFilename) {
        this.userFilename = userFilename;
    }

    @Builder
    public User(Long userId, String userEmail, String userName, String userPassword, String userNickname, String userFilename) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.userFilename = userFilename;
    }
}

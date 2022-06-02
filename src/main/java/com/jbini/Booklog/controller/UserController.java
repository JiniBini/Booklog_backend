package com.jbini.Booklog.controller;


import com.jbini.Booklog.dto.UserLoginResponseDto;
import com.jbini.Booklog.dto.UserResponseDto;
import com.jbini.Booklog.exception.BaseResponse;
import com.jbini.Booklog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "회원 목록 조회", notes = "모든 회원을 조회합니다.")
    @GetMapping("/users")
    public BaseResponse<List<UserResponseDto>> findAllUsers() {
        return new BaseResponse(HttpStatus.OK, "All Users", userService.findAllUser());
    }

//    @ApiOperation(value = "로그인", notes = "이메일로 로그인을 합니다.")
//    @PostMapping("/login")
//    public BaseResponse<UserLoginResponseDto> login(@ApiParam(value = "회원 한 명의 정보를 갖는 객체", required = true) @RequestBody UserLoginRequestDto userLoginDto) throws Exception {
//
//        return new BaseResponse(userService.login(userLoginDto).getStatus(), "요청 성공했습니다.", userService.login(userLoginDto).getToken());
//    }



}

package sopt.org.ThirdAdvanced.service;

import sopt.org.ThirdAdvanced.controller.dto.request.UserSignUpDto;
import sopt.org.ThirdAdvanced.domain.User;

import java.util.Optional;

public interface UserService {

    //* 유저 회원가입
    void signUp(UserSignUpDto userSignUpDto);
}

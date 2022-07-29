package com.example.yssyk_cool.service.auth;


import com.example.yssyk_cool.dto.user.request.UserAuthRequest;
import com.example.yssyk_cool.dto.user.request.UserRequest;
import com.example.yssyk_cool.dto.user.response.UserResponse;
import com.example.yssyk_cool.dto.user.response.UserTokenResponse;
import com.example.yssyk_cool.entity.User;
import com.example.yssyk_cool.exception.UserSignInException;
import com.example.yssyk_cool.service.BaseService;

public interface UserService extends BaseService<UserResponse, UserRequest> {

    UserTokenResponse getToken(UserAuthRequest request) throws UserSignInException;

    void addRoleToUser(Long id);

    boolean check(String check);
}

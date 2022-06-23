package com.example.yssyk_cool.mapper;

import com.example.yssyk_cool.dto.user.request.UserAuthRequest;
import com.example.yssyk_cool.dto.user.request.UserRequest;
import com.example.yssyk_cool.dto.user.response.UserResponse;
import com.example.yssyk_cool.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    

    UserResponse toUserResponseDto(User user);

    List<UserResponse> toUsersResponseDto(List<User> users);

    UserAuthRequest toUserAuthDto(User user);

    User toUserEntity(UserResponse userResponse);

    default void test(UserRequest userRequest){

    }
}
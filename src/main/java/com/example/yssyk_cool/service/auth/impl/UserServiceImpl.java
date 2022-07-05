package com.example.yssyk_cool.service.auth.impl;

import com.example.yssyk_cool.dto.user.request.UserAuthRequest;
import com.example.yssyk_cool.dto.user.request.UserRequest;
import com.example.yssyk_cool.dto.user.response.UserResponse;
import com.example.yssyk_cool.dto.user.response.UserTokenResponse;
import com.example.yssyk_cool.entity.Role;
import com.example.yssyk_cool.entity.User;
import com.example.yssyk_cool.entity.UserRole;
import com.example.yssyk_cool.exception.EmailNotBeEmptyException;
import com.example.yssyk_cool.exception.NotFoundException;
import com.example.yssyk_cool.exception.UserSignInException;
import com.example.yssyk_cool.mapper.UserMapper;
import com.example.yssyk_cool.repository.RoleRepository;
import com.example.yssyk_cool.repository.UserRepository;
import com.example.yssyk_cool.repository.UserRoleRepository;
import com.example.yssyk_cool.service.auth.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    final RoleRepository roleRepository;

    final PasswordEncoder passwordEncoder;

    final UserRoleRepository userRoleRepository;


    @Override
    public UserResponse save(UserRequest t) {
        if (t.getEmail() == null)
            throw new EmailNotBeEmptyException("email is empty", HttpStatus.valueOf("EMAIL_NOT_BE_EMPTY"));
        User userEntity = userRepository
                .save(User.builder()
                        .login(t.getLogin())
                        .email(t.getEmail())
                        .password(passwordEncoder.encode(t.getPassword()))
                        .isActive(true)
                        .build());

        userRoleRepository
                .save(UserRole.builder()
                        .role(roleRepository.findById(2L).orElse(new Role()))
                        .user(userEntity).build());

        UserResponse userResponse = UserMapper.INSTANCE.toUserResponseDto(userEntity);
        userResponse.setToken(generateToken(userEntity));

        return userResponse;
    }

    @Override
    public UserTokenResponse getToken(UserAuthRequest request) {
//        User userEntity = userRepository.findByUserNameAndEMail(request.getLoginOrEmail());
        User userEntity = userRepository.findByEmail(request.getLoginOrEmail());
        boolean isMatches;
        if (userEntity != null){
            isMatches = passwordEncoder.matches(request.getPassword(), userEntity.getPassword());
        }else {
            userEntity = userRepository.findByLogin(request.getLoginOrEmail());
            isMatches = passwordEncoder.matches(request.getPassword(),userEntity.getPassword());
        }
        if (isMatches) {
            String token = "Basic " + new String(Base64.getEncoder()
                    .encode((userEntity.getLogin() + ":" + request.getPassword()).getBytes()));
            return UserTokenResponse.builder()
                    .userToken(token).build();
        } else {
            throw new UserSignInException("Неправильный логин или пароль!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String generateToken(User user) {
        return "Basic " + new String(Base64.getEncoder()
                .encode((user.getLogin() + ":" + user.getPassword()).getBytes()));
    }


    @Override
    public List<UserResponse> getAll() {
        return UserMapper.INSTANCE.toUsersResponseDto(userRepository.findAll());
    }

    @Override
    public UserResponse findById(Long id) {
        return UserMapper.INSTANCE.toUserResponseDto(
                userRepository.findById(id).orElseThrow(() -> new NotFoundException("not found user", HttpStatus.NOT_FOUND)));
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

}

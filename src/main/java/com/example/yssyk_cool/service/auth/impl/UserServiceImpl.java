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
import com.example.yssyk_cool.exception.UserNotActiveException;
import com.example.yssyk_cool.exception.UserSignInException;
import com.example.yssyk_cool.mapper.UserMapper;
import com.example.yssyk_cool.repository.RoleRepository;
import com.example.yssyk_cool.repository.UserRepository;
import com.example.yssyk_cool.repository.UserRoleRepository;
import com.example.yssyk_cool.service.auth.UserService;
import com.example.yssyk_cool.enums.SecurityRole;
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
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    final RoleRepository roleRepository;

    final PasswordEncoder passwordEncoder;

    final UserRoleRepository userRoleRepository;


    @Override
    @Transactional
    public UserResponse save(UserRequest t) {
        if (t.getEmail() == null)
            throw new EmailNotBeEmptyException("email is empty", HttpStatus.BAD_REQUEST);

        checkToHave(t.getLogin(),t.getEmail());

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

        userResponse.setToken(generateToken(t));

        return userResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public UserTokenResponse getToken(UserAuthRequest request) {

        User userEntity = userRepository.findByEmail(request.getLogin());
        boolean isMatches;

        if (userEntity == null) {
            userEntity = userRepository.findByLogin(request.getLogin());
        }

        isMatches = passwordEncoder.matches(request.getPassword(), userEntity.getPassword());

        if (!userEntity.getIsActive()) throw new UserNotActiveException("Пользователь заблокирован", HttpStatus.BAD_REQUEST);

        if (isMatches) {
            String token = "Basic " + new String(Base64.getEncoder()
                    .encode((userEntity.getLogin() + ":" + request.getPassword()).getBytes()));
            return UserTokenResponse.builder()
                    .userId(userEntity.getId())
                    .userToken(token).build();
        } else {
            throw new UserSignInException("Неправильный логин или пароль!", HttpStatus.NOT_FOUND);
        }
    }


    private String generateToken(UserRequest user) {
        return "Basic " + new String(Base64.getEncoder()
                .encode((user.getLogin() + ":" + user.getPassword()).getBytes()));
    }

    @Override
    @Transactional
    public void addRoleToUser(Long id) {
        User user = userRepository
                .findById(id).orElseThrow(()->new NotFoundException("User not found",HttpStatus.BAD_REQUEST));
        List<UserRole> roles = userRoleRepository.findByUserId(user.getId());
        for (UserRole role : roles) {
            if (role.getRole().getRole().equals(SecurityRole.ROLE_PROVIDER.name())){
                return;
            }
        }
        userRoleRepository.save(UserRole.builder()
                .role(roleRepository
                        .findById(3L).orElseThrow(()->new NotFoundException("Role not foudnd",HttpStatus.BAD_REQUEST)))
                .user(user)
                .build());
    }

    @Override
    public boolean check(String check) {
        User user = userRepository.findByEmail(check);

        return user == null;
    }

    @Override
    public UserResponse editPassword(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null){

        }
        return null;
    }

    private void checkToHave(String login, String email){

        User user = userRepository.findByLogin(login);
        if (user != null){
            throw new UserSignInException("Такой login уже сушествует!",HttpStatus.BAD_REQUEST);
        }
        user = null;
        user = userRepository.findByEmail(email);
        if (user != null){
            throw new UserSignInException("Такой email уже сушествует!",HttpStatus.BAD_REQUEST);
        }

    }


    @Override
    public List<UserResponse> getAll() {
        return UserMapper.INSTANCE.toUsersResponseDto(userRepository.findAll());
    }

    @Override
    public UserResponse findById(Long id) {
        return UserMapper.INSTANCE.toUserResponseDto(
                userRepository.findById(id).orElseThrow(() -> new NotFoundException("not found user", HttpStatus.BAD_REQUEST)));
    }

    @Override
    public UserResponse delete(Long id) {
        return null;
    }

}

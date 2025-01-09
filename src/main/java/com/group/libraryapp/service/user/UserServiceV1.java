package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.response.UserResponse;
import com.group.libraryapp.dto.user.UserCreateRequest;
import com.group.libraryapp.dto.user.UserUpdateRequest;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {
    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void updateUser(UserUpdateRequest request) {
        if(userJdbcRepository.isUserNotExist(request.getId())){
            throw new IllegalArgumentException("user not found");
        }

        userJdbcRepository.updateUserName(request.getId(), request.getName());
    }

    public void deleteUser(String name) {
        if(userJdbcRepository.isUserNotExist(name)){
            throw new IllegalArgumentException("user not found");
        }

        userJdbcRepository.deleteUser(name);
    }

    public void saveUser(UserCreateRequest request) {
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> getUsers(){
        return userJdbcRepository.getUsers();
    }
}

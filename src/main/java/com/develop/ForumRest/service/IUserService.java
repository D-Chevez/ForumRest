package com.develop.ForumRest.service;

import com.develop.ForumRest.dto.UserCreateDTO;
import com.develop.ForumRest.dto.UserUpdateDTO;
import com.develop.ForumRest.model.User;

import java.util.List;

public interface IUserService {
    User createUser(UserCreateDTO userCreateDTO);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(UserUpdateDTO userUpdateDTO);
    void deleteUser(Long userId);
    void deactivateUser(Long userId);
}

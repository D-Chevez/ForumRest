package com.develop.ForumRest.service;

import com.develop.ForumRest.dto.UserCreateDTO;
import com.develop.ForumRest.dto.UserListDTO;
import com.develop.ForumRest.dto.UserUpdateDTO;
import com.develop.ForumRest.model.Role;
import com.develop.ForumRest.model.Status;
import com.develop.ForumRest.model.User;
import com.develop.ForumRest.repository.RoleRepository;
import com.develop.ForumRest.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User createUser(UserCreateDTO userCreateDTO) {
        Role role = roleRepository.findById(userCreateDTO.roleId()).orElseThrow(() -> new IllegalArgumentException("Role not found"));
        User user = new User(userCreateDTO, role);
        String encodedPassword = passwordEncoder.encode(userCreateDTO.password());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User updateUser(UserUpdateDTO userUpdateDTO) {

        User user = userRepository.findById(userUpdateDTO.userId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Role role = roleRepository.findById(userUpdateDTO.roleId()).orElseThrow(() -> new IllegalArgumentException("Role not found"));

        if(user != null && role != null){
            if(userUpdateDTO.username() != null){
                user.setUsername(userUpdateDTO.username());
            }

            if(userUpdateDTO.email() != null){
                user.setEmail(userUpdateDTO.email());
            }

            if(userUpdateDTO.password() != null){
                user.setPassword(userUpdateDTO.password());
            }

            if(userUpdateDTO.roleId() != null){
                user.setRole(role);
            }

            if(userUpdateDTO.status() != null){
                user.setStatus(userUpdateDTO.status());
            }

            return userRepository.save(user);
        }

        return null;
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    @Transactional
    public void deactivateUser(Long userId) {
        User existingUser = getUserById(userId);
        if (existingUser != null) {
            existingUser.setStatus(Status.INACTIVE);
            userRepository.save(existingUser);
        }
    }


    public Page<UserListDTO> getAll(Pageable pagination){
        return userRepository.findAll(pagination).map(UserListDTO::new);
    }
}

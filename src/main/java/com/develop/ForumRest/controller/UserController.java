package com.develop.ForumRest.controller;

import com.develop.ForumRest.dto.UserCreateDTO;
import com.develop.ForumRest.dto.UserDetailDTO;
import com.develop.ForumRest.dto.UserListDTO;
import com.develop.ForumRest.dto.UserUpdateDTO;
import com.develop.ForumRest.model.User;
import com.develop.ForumRest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    //READE
    @GetMapping
    public ResponseEntity<Page<UserListDTO>> getUsers(@PageableDefault(size = 5) Pageable pagination) {
        Page<UserListDTO> users = userService.getAll(pagination);
        return ResponseEntity.ok(users);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<UserDetailDTO> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO, UriComponentsBuilder uriComponentsBuilder) {
        User userCreate = userService.createUser(userCreateDTO);
        UserDetailDTO userDetailDTO = new UserDetailDTO(userCreate);

        URI url = uriComponentsBuilder.path("/users/{id}").buildAndExpand(userCreate.getUserId()).toUri();
        return ResponseEntity.created(url).body(userDetailDTO);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserDetailDTO> updateUser(@RequestBody @Valid UserUpdateDTO userUpdateDTO, UriComponentsBuilder uriComponentsBuilder) {
        User userUpdate = userService.updateUser(userUpdateDTO);
        UserDetailDTO userDetailDTO = new UserDetailDTO(userUpdate);
        return ResponseEntity.ok(userDetailDTO);
    }

    //LOGIC DELETE
    @PutMapping("/deactivate/{id}")
    public ResponseEntity deactivateUser(@PathVariable Long id) {
        userService.deactivateUser(id);
        return ResponseEntity.noContent().build();
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDTO> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        UserDetailDTO userDetailDTO = new UserDetailDTO(user);
        return ResponseEntity.ok(userDetailDTO);
    }
}

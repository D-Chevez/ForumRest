package com.develop.ForumRest.controller;

import com.develop.ForumRest.dto.*;
import com.develop.ForumRest.model.Role;
import com.develop.ForumRest.model.User;
import com.develop.ForumRest.service.RoleService;
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
@RequestMapping("/Roles")
public class RoleController {

    @Autowired
    RoleService roleService;



}

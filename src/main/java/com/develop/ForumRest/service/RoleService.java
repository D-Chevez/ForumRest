package com.develop.ForumRest.service;

import com.develop.ForumRest.dto.RoleCreateDTO;
import com.develop.ForumRest.dto.RoleDetailDTO;
import com.develop.ForumRest.dto.RoleListDTO;
import com.develop.ForumRest.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Override
    public Role createRole(RoleCreateDTO dto) {
        return null;
    }

    @Override
    public Role getRoleById(Long roleId) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return List.of();
    }

    @Override
    public Role updateRole(RoleDetailDTO dto) {
        return null;
    }

    @Override
    public void deleteRole(Long roleId) {

    }

    @Override
    public void deactivateRole(Long roleId) {

    }
}
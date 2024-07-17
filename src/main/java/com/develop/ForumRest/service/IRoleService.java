package com.develop.ForumRest.service;

import com.develop.ForumRest.dto.RoleCreateDTO;
import com.develop.ForumRest.dto.RoleDetailDTO;
import com.develop.ForumRest.model.Role;

import java.util.List;

public interface IRoleService {
    Role createRole(RoleCreateDTO dto);
    Role getRoleById(Long roleId);
    List<Role> getAllRoles();
    Role updateRole(RoleDetailDTO dto);
    void deleteRole(Long roleId);
    void deactivateRole(Long roleId);
}

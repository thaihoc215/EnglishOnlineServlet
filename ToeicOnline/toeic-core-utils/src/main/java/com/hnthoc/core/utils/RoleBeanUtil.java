package com.hnthoc.core.utils;

import com.hnthoc.core.dto.RoleDTO;
import com.hnthoc.core.persistence.entity.RoleEntity;

public class RoleBeanUtil {

    /**
     * convert role entity to DTO
     * @param roleEntity
     * @return
     */
    public static RoleDTO entity2Dto (RoleEntity roleEntity) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(roleEntity.getName());
        roleDTO.setRoleId(roleEntity.getRoleId());
        return roleDTO;
    }

    /**
     * convert role DTO to entity
     * @param roleDTO
     * @return
     */
    public static RoleEntity dto2Entity (RoleDTO roleDTO) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(roleDTO.getName());
        roleEntity.setRoleId(roleDTO.getRoleId());
        return roleEntity;
    }
}

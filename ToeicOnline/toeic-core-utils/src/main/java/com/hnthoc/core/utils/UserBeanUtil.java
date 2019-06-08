package com.hnthoc.core.utils;

import com.hnthoc.core.dto.UserDTO;
import com.hnthoc.core.persistence.entity.UserEntity;

public class UserBeanUtil {
    /**
     * convert user entity to DTO
     * @param userEntity
     * @return
     */
    public static UserDTO entity2Dto(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setName(userEntity.getName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setFullName(userEntity.getFullName());
        userDTO.setCreatedDate(userEntity.getCreatedDate());
        userDTO.setRoleDTO(RoleBeanUtil.entity2Dto(userEntity.getRoleEntity()));
        return userDTO;

    }

    /**
     * convert user DTO to entity
     * @param userDTO
     * @return
     */
    public static UserEntity dto2Entity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setName(userDTO.getName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setCreatedDate(userDTO.getCreatedDate());
        userEntity.setRoleEntity(RoleBeanUtil.dto2Entity(userDTO.getRoleDTO()));
        return userEntity;

    }

}

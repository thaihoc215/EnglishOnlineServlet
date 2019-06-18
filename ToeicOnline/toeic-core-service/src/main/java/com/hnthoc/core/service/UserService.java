package com.hnthoc.core.service;

import com.hnthoc.core.dto.UserDTO;

public interface UserService {
    /**
     * check does user is exist
     * @param userDTO
     * @return
     */
    UserDTO isUserExist(UserDTO userDTO);

    /**
     * find role of an user
     * @param userDTO
     * @return
     */
    UserDTO findRoleByUser(UserDTO userDTO);
}

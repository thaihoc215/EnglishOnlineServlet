package com.hnthoc.core.service.impl;

import com.hnthoc.core.dto.UserDTO;
import com.hnthoc.core.service.UserService;
import com.hnthoc.core.utils.UserBeanUtil;
import com.hochnt.core.dao.UserDao;
import com.hochnt.core.daoimpl.UserDaoImpl;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    public UserDTO isUserExist(UserDTO userDTO) {
        UserDTO dto = UserBeanUtil.entity2Dto(userDao.findUserByUsernameAndPassword(userDTO.getName(),userDTO.getPassword()));
        return dto;
    }

    public UserDTO findRoleByUser(UserDTO userDTO) {
        return UserBeanUtil.entity2Dto(userDao.findUserByUsernameAndPassword(userDTO.getName(),userDTO.getPassword()));
    }
}

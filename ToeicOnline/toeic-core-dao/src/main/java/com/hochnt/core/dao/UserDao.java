package com.hochnt.core.dao;

import com.hochnt.core.data.dao.GenericDao;
import com.hnthoc.core.persistence.entity.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {
    /**
     * Check user exist in db
     * @param userName
     * @param password
     * @return
     */
    UserEntity isUserExist(String userName, String password);

    UserEntity findRoleByUser(String userName, String password);
}

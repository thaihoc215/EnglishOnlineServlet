package com.hochnt.core.dao;

import com.hochnt.core.data.dao.GenericDao;
import com.hnthoc.core.persistence.entity.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {
    /**
     * find a an user via user name and password
     * @param userName
     * @param password
     * @return
     */
    UserEntity findUserByUsernameAndPassword(String userName, String password);
}

package com.hochnt.api.test;

import com.hnthoc.core.persistence.entity.UserEntity;
import com.hochnt.core.dao.UserDao;
import com.hochnt.core.daoimpl.UserDaoImpl;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest {
    private final Logger log = Logger.getLogger(this.getClass());
    @Test
    public void checkIsUserExist(){
        UserDao dao = new UserDaoImpl();
        UserEntity entity = dao.isUserExist("admin", "123456");
        if(entity!= null) {
            log.info("login success");
            System.out.println(entity.getName());
            System.out.println(entity.getPassword());
        } else {
            log.error("user not found");
        }

        entity = dao.isUserExist("admin1", "123456");

        if(entity!= null) {
            log.info("login success");
            System.out.println(entity.getName());
            System.out.println(entity.getPassword());
        } else {
            log.error("user not found");
            System.out.println("user not found");
        }
    }

    @Test
    public void checkFindRoleUser(){
        UserDao dao = new UserDaoImpl();
        UserEntity entity = dao.isUserExist("admin", "123456");
        if(entity!= null) {
            log.info("login success");
            log.info(String.format("User : %s - Role: %s", entity.getName(),entity.getRoleEntity().getName()));
            System.out.println(entity.getName());
            System.out.println(entity.getPassword());
        } else {
            log.error("user not found");
        }
    }
}

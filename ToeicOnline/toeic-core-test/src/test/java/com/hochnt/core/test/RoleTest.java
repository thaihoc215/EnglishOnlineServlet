package com.hochnt.core.test;

import com.hochnt.core.dao.RoleDao;
import com.hochnt.core.daoimpl.RoleDaoImpl;
import com.hochnt.core.persistence.entity.RoleEntity;
import org.testng.annotations.Test;

import java.util.List;

public class RoleTest {

    @Test
    public void checkFindAll(){
        RoleDao dao = new RoleDaoImpl();
        List<RoleEntity> list = dao.findAll();
        System.out.println("List roles size: " + list.size());
    }

    @Test
    public void checkUpdateRole(){
        RoleDao dao = new RoleDaoImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(2);
        roleEntity.setName("USER_1");
        dao.update(roleEntity);
    }

    @Test
    public void checkSaveRole(){
        RoleDao dao = new RoleDaoImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(3);
        roleEntity.setName("MANAGER");
        dao.save(roleEntity);
    }

    @Test
    public void checkFindId(){
        RoleDao dao = new RoleDaoImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity = dao.findById(3);
        System.out.println(roleEntity.getName());
    }
}

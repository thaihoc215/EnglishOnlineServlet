package com.hochnt.core.test;

import com.hochnt.core.dao.RoleDao;
import com.hochnt.core.daoimpl.RoleDaoImpl;
import com.hochnt.core.persistence.entity.RoleEntity;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    public void testFindByProperty(){
        RoleDao dao = new RoleDaoImpl();
        Object[] roleFind = dao.findByProperty("name", "ADMIN", "name", "2");
        Object[] roleFind2 = dao.findByProperty(null, null, null, null);
        System.out.println(roleFind[1].toString());
    }

    @Test
    public void testDelete() {
        List<Integer> lst = new ArrayList<Integer>(Arrays.asList(4,5));
        RoleDao dao = new RoleDaoImpl();
        int count = dao.delete(lst);
        System.out.println(count);
    }
}

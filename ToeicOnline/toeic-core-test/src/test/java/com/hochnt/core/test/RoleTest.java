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
    }
}

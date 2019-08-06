package com.hochnt.api.test;

import com.hnthoc.core.persistence.entity.ListenGuideLineEntity;
import com.hochnt.core.dao.ListenGuideLineDao;
import com.hochnt.core.daoimpl.ListenGuideLineDaoImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListenGuidelineTest {

    ListenGuideLineDao listenGuideLineDao;

    @BeforeTest
    public void initData() {
        listenGuideLineDao = new ListenGuideLineDaoImpl();
    }

    @Test
    public void testFindByProperties() {
//        ListenGuideLineDao lineDao = new ListenGuideLineDaoImpl();
        Object[] lineEntities = listenGuideLineDao.findByProperty(null, null, null, 2, 2);
        if ((Long) lineEntities[1] > 0) {
            List<ListenGuideLineEntity> lst = (List<ListenGuideLineEntity>) lineEntities[0];
            for (ListenGuideLineEntity idx : lst) {
                System.out.println(String.format("%s : %s", idx.getTitle(), idx.getContent()));
            }
        } else {
            System.out.println("No listen guideline");
        }
    }

    @Test
    public void checkApiFindByProperty() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("title", "Bai hd 8");
        properties.put("content", "Noi dung bai hd 8");

        Object[] lineEntities = listenGuideLineDao.findByProperty(properties, null, null, null, null);
        if ((Long) lineEntities[1] > 0) {
            List<ListenGuideLineEntity> lst = (List<ListenGuideLineEntity>) lineEntities[0];
            for (ListenGuideLineEntity idx : lst) {
                System.out.println(String.format("%s : %s", idx.getTitle(), idx.getContent()));
            }
        } else {
            System.out.println("No listen guideline");
        }
    }

}


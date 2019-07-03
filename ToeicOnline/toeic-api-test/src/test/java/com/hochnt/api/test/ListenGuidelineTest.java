package com.hochnt.api.test;

import com.hnthoc.core.persistence.entity.ListenGuideLineEntity;
import com.hochnt.core.dao.ListenGuideLineDao;
import com.hochnt.core.daoimpl.ListenGuideLineDaoImpl;
import org.testng.annotations.Test;

import java.util.List;

public class ListenGuidelineTest {
    @Test
    public void testFindByProperties() {
        ListenGuideLineDao lineDao = new ListenGuideLineDaoImpl();
        Object[] lineEntities = lineDao.findByProperty(null, null, null, null, 2, 2);
        if ((Integer) lineEntities[1] > 0) {
            List<ListenGuideLineEntity> lst = (List<ListenGuideLineEntity>) lineEntities[0];
            for (ListenGuideLineEntity idx : lst) {
                System.out.println(String.format("%s : %s", idx.getTitle(), idx.getContent()));
            }
        } else {
            System.out.println("No listen guideline");
        }
    }

}


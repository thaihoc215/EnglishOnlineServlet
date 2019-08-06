package com.hnthoc.core.service.impl;

import com.hnthoc.core.dto.ListenGuidelineDTO;
import com.hnthoc.core.persistence.entity.ListenGuideLineEntity;
import com.hnthoc.core.service.ListenGuidelineService;
import com.hnthoc.core.utils.ListenGuidelineBeanUtil;
import com.hochnt.core.dao.ListenGuideLineDao;
import com.hochnt.core.daoimpl.ListenGuideLineDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {

    private ListenGuideLineDao listenGuideLineDao = new ListenGuideLineDaoImpl();

    public Object[] findListenGuidelineByProperties(String property, Object value, String sortExpression, String direction, Integer offset, Integer limit) {
        /*Object[] lstDataAndSize = listenGuideLineDao.findByProperty(property, sortExpression, direction, offset, limit);
        List<ListenGuideLineEntity> lstListen = (List<ListenGuideLineEntity>)lstDataAndSize[0];
        List<ListenGuidelineDTO> result = new ArrayList<ListenGuidelineDTO>();
        for(ListenGuideLineEntity item : lstListen) {
            ListenGuidelineDTO dto = ListenGuidelineBeanUtil.entity2Dto(item);
            result.add(dto);
        }
        lstDataAndSize[0] = result;
        return lstDataAndSize;*/
        return null;
    }
}

package com.hnthoc.core.utils;

import com.hnthoc.core.dto.ListenGuidelineDTO;
import com.hnthoc.core.dto.UserDTO;
import com.hnthoc.core.persistence.entity.ListenGuideLineEntity;
import com.hnthoc.core.persistence.entity.UserEntity;

public class ListenGuidelineBeanUtil {
    /**
     * convert listen guideline entity to DTO
     * @param listenGuideLineEntity
     * @return
     */
    public static ListenGuidelineDTO entity2Dto(ListenGuideLineEntity listenGuideLineEntity) {
        if(listenGuideLineEntity == null)
            return null;
        ListenGuidelineDTO listenGuidelineDTO = new ListenGuidelineDTO();
        listenGuidelineDTO.setListenGuideLineId(listenGuideLineEntity.getListenGuideLineId());
        listenGuidelineDTO.setTitle(listenGuideLineEntity.getTitle());
        listenGuidelineDTO.setImage(listenGuideLineEntity.getImage());
        listenGuidelineDTO.setContent(listenGuideLineEntity.getContent());
        listenGuidelineDTO.setCreatedDate(listenGuideLineEntity.getCreatedDate());
        listenGuidelineDTO.setModifiedDate(listenGuideLineEntity.getModifiedDate());
        return listenGuidelineDTO;

    }

    /**
     * convert user DTO to entity
     * @param listenGuidelineDTO
     * @return
     */
    public static ListenGuideLineEntity dto2Entity(ListenGuidelineDTO listenGuidelineDTO) {
        if(listenGuidelineDTO == null)
            return null;
        ListenGuideLineEntity listenGuideLineEntity = new ListenGuideLineEntity();
        listenGuideLineEntity.setListenGuideLineId(listenGuidelineDTO.getListenGuideLineId());
        listenGuideLineEntity.setTitle(listenGuidelineDTO.getTitle());
        listenGuideLineEntity.setImage(listenGuidelineDTO.getImage());
        listenGuideLineEntity.setContent(listenGuidelineDTO.getContent());
        listenGuideLineEntity.setCreatedDate(listenGuidelineDTO.getCreatedDate());
        listenGuideLineEntity.setModifiedDate(listenGuidelineDTO.getModifiedDate());
        return listenGuideLineEntity;

    }

}

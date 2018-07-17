package com.hochnt.core.data.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable, T> {
    /**
     * Find all records
     * @return
     */
    List<T> findAll();

    /**
     * Update entity value
     * @param entity
     * @return
     */
    T update(T entity);
}

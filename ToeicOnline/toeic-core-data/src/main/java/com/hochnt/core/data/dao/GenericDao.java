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

    void save(T entity);

    T findById(ID id);

    Object[] findByProperty(String property, Object value, String sortExpresion, String direction );

    /**
     * Delete list item by item ids
     * @param ids
     * @return
     */
    Integer delete(List<ID> ids);
}

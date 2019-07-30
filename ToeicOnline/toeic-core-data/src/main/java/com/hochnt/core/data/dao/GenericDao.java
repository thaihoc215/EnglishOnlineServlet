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

    /**
     *
     * @param property
     * @param value
     * @param sortExpression
     * @param direction
     * @param offset
     * @param limit
     * @return objects: 0 - list entity, 1 - number size of list
     */
    Object[] findByProperty(String property, Object value, String sortExpression, String direction, Integer offset, Integer limit);

    /**
     * Delete list item by item ids
     * @param ids
     * @return
     */
    Integer delete(List<ID> ids);
}

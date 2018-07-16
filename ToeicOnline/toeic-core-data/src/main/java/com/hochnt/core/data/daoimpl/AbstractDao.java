package com.hochnt.core.data.daoimpl;

import com.hochnt.core.common.utils.HibernateUtil;
import com.hochnt.core.data.dao.GenericDao;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    //method get class name
    private Class<T> persistenceClass;

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];//lay class cua class cha
    }

    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public List<T> findAll() {
        return null;
    }
}

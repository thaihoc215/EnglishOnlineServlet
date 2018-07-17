package com.hochnt.core.data.daoimpl;

import com.hochnt.core.common.utils.HibernateUtil;
import com.hochnt.core.data.dao.GenericDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    //method get class name
    private Class<T> persistenceClass;

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];//lay class cua class cha
    }

    public String getPersistenceClassName(){
        return this.persistenceClass.getName();
    }

    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Transaction transaction = null;
        try {

            transaction = getSession().beginTransaction();
            StringBuilder hql = new StringBuilder("from ");
            hql.append(getPersistenceClassName());
            Query query = this.getSession().createQuery(hql.toString());
            list = query.list();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }

        return list;
    }
}

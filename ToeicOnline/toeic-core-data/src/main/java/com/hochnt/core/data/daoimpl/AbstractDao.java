package com.hochnt.core.data.daoimpl;

import com.hochnt.core.common.utils.HibernateUtil;
import com.hochnt.core.data.dao.GenericDao;
import org.hibernate.*;

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            StringBuilder hql = new StringBuilder("from ");
            hql.append(getPersistenceClassName());
            Query query = session.createQuery(hql.toString());
            list = query.list();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return list;
    }

    public T update(T entity) {
        T rs = null;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object obj = session.merge(entity);
            rs = (T) obj;
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return rs;
    }

    public void save(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    public T findById(ID id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        T rs = null;
        try {
            rs = (T) session.get(persistenceClass,id);
            if (rs==null)
                throw new ObjectNotFoundException("NOT FOUNT " + id, null);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return rs;
    }
}

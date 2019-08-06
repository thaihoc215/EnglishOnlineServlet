package com.hochnt.core.data.daoimpl;

import com.hochnt.core.common.constant.CoreConstant;
import com.hochnt.core.common.utils.HibernateUtil;
import com.hochnt.core.data.dao.GenericDao;
import com.mysql.cj.util.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    //method get class name
    private Class<T> persistenceClass;

    public AbstractDao() {
        // using reflection -> put entity
        //lay class cua class class duoc khoi tao va implement GenericDAO
        // Generic Dao có 2 param<ID,T>, hàm get class lấy ra được class tương ứng và get ra đúng type của argument vị trí n
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName() {
        return this.persistenceClass.getName();
    }

    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Find all data of entity mapped to table in db
     *
     * @return List data with type of Entity
     */
    public List<T> findAll() {
        List<T> list;
        Session session = getSession();
        //Transaction transaction = null;
        try {
            // Old type: HQL
            /*transaction = session.beginTransaction();
            StringBuilder hql = new StringBuilder("from ");
            hql.append(getPersistenceClassName());
            list = session.createQuery(hql.toString()).getResultList();
            transaction.commit();*/

            //use for hibernate 5.0 upper (JPA)
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cr = cb.createQuery(persistenceClass);
            Root<T> root = cr.from(persistenceClass);
            cr.select(root);
            list = session.createQuery(cr).getResultList();
        } catch (HibernateException e) {
            //transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return list;
    }

    /**
     * Update an data record mapped to entity
     *
     * @param entity
     * @return
     */
    public T update(T entity) {
        T rs;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            // HLA
            Object obj = session.merge(entity);
            rs = (T) obj;
            //JPA
            /*CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaUpdate<T> cu = cb.createCriteriaUpdate(this.persistenceClass);
            Root<T> root = cu.from(this.persistenceClass);*/
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * add an data record of table mapped to entity
     *
     * @param entity
     */
    public void save(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    /**
     * find an data record mapped to entity by unique ID
     *
     * @param id
     * @return An entity class
     */
    public T findById(ID id) {
        Session session = getSession();
        //Transaction transaction = session.beginTransaction();
        T rs = null;
        try {
            // Dựa vào annotation ID đã đánh đấu ở các entity
            rs = (T) session.get(persistenceClass, id);
            if (rs == null)
                throw new ObjectNotFoundException("NOT FOUNT " + id, null);
            //JPA
            /*CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cr = cb.createQuery(this.persistenceClass);
            Root<T> root = cr.from(this.persistenceClass);
            cr.select(root).where(cb.equal(root.get("roleId"), id));
            rs = session.createQuery(cr).getSingleResult();*/

            //transaction.commit();
        } catch (NoResultException e) {
            //transaction.rollback();
//            throw e;
            throw new ObjectNotFoundException("NOT FOUNT " + id, null);
        } finally {
            session.close();
        }
        return rs;
    }

    public Object[] findByProperty(Map<String, Object> properties, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Session session = getSession();
        Object[] rs = new Object[2];
        List<T> list;
        int propertiesSize = properties.size();
        ArrayList<String> params = new ArrayList<String>();
        ArrayList<Object> values = new ArrayList<Object>();


        for (Map.Entry item : properties.entrySet()) {
            params.add((String) item.getKey());
            values.add(item.getValue());
        }
        try {

            // using HQL
            /*StringBuilder hql = new StringBuilder("from ");
            hql.append(getPersistenceClassName());
            if (!StringUtils.isNullOrEmpty(property) && value != null) {
                hql.append(" where ").append(property).append(" =:value");
            }
            if (!StringUtils.isNullOrEmpty(sortExpression) && !StringUtils.isNullOrEmpty(direction)) {
                hql.append(" order by ").append(sortExpression);
                hql.append(" " + (sortExpression.equals(CoreConstant.SORT_ASC) ? "ASC" : "DESC"));
            }

            Query<T> query = session.createQuery(hql.toString());
            if (!StringUtils.isNullOrEmpty(property) && value != null) {
             query.setParameter("value",value);
            }

            if(offset != null && offset >- 0){
                query.setFirstResult(offset);
            }
            if(limit != null && limit > 0) {
                query.setMaxResults(limit);
            }
            list = query.getResultList();*/


            //use JPA
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cr = cb.createQuery(persistenceClass);
            Root<T> root = cr.from(persistenceClass);
            cr.select(root);

            if (propertiesSize > 0) {
                Predicate[] predicates = new Predicate[propertiesSize];
                for (int i = 0; i < propertiesSize; i++) {
                    predicates[i] = cb.equal(root.get(params.get(i)), values.get(i));
                }
                cr.where(predicates);
            }
            if (!StringUtils.isNullOrEmpty(sortExpression) && !StringUtils.isNullOrEmpty(sortDirection)) {
                cr.orderBy(sortDirection.equals(CoreConstant.SORT_ASC) ? cb.asc(root.get(sortExpression)) : cb.desc(root.get(sortExpression)));
            }

            Query<T> query = session.createQuery(cr);
            if (offset != null && offset > 0) {
                query.setFirstResult(offset);
            }
            if (limit != null && limit > 0) {
                query.setMaxResults(limit);
            }

            list = query.getResultList();
            rs[0] = list;

            StringBuilder sql2 = new StringBuilder("select count(*) from ");
            sql2.append(getPersistenceClassName());
            if (propertiesSize > 0) {
                sql2.append(" where 1 = 1");
                for (int i = 0; i < propertiesSize; i++) {
                    sql2.append(" and ").append(params.get(i)).append(" =:" + params.get(i));
                }
            }
            Query query2 = session.createQuery(sql2.toString());
            if (propertiesSize > 0) {
                sql2.append(" where 1 = 1");
                for (int i = 0; i < propertiesSize; i++) {
                    query2.setParameter(params.get(i), values.get(i));
                }
            }
            rs[1] = query2.list().get(0);
        } catch (HibernateException e) {
            //transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return rs;
    }

    public Integer delete(List<ID> ids) {
        // using HQL basic
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        int count = 0;
        try {
            for (ID id : ids) {
                T t = session.get(persistenceClass, id);
                if (t == null)
                    continue;
                session.delete(t);
                count++;
            }
            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return count;
    }
}

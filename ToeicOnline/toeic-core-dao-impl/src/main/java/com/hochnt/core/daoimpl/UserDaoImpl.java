package com.hochnt.core.daoimpl;

import com.hochnt.core.dao.UserDao;
import com.hochnt.core.data.daoimpl.AbstractDao;
import com.hnthoc.core.persistence.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {

    public UserEntity isUserExist(String userName, String password) {
        UserEntity entity;
        Session session = getSession();
        try {
            // Old type: HQL
            StringBuilder hql = new StringBuilder("from ");
            hql.append(getPersistenceClassName());
            hql.append(" where name=:name ");
            hql.append(" and password=:password");
            Query<UserEntity> query = session.createQuery(hql.toString());
            query.setParameter("name", userName);
            query.setParameter("password", password);

            entity = query.uniqueResult();

            //use for hibernate 5.0 upper (JPA)
           /* CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cr = cb.createQuery(persistenceClass);
            Root<T> root = cr.from(persistenceClass);
            cr.select(root);
            list = session.createQuery(cr).getResultList();*/
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }

        return entity;
    }

    public UserEntity findRoleByUser(String userName, String password) {
        return isUserExist(userName,password);
    }
}

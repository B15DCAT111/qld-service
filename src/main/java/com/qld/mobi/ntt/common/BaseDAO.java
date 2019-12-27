package com.qld.mobi.ntt.common;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BaseDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Session getSession() {
        return (Session) entityManager.getDelegate();
    }

    // <editor-fold defaultstate="collapsed" desc="Tim Kiem">
    public <T> List<T> getAll(Class<T> tableName, String orderColumn) {
        String hql = " FROM " + tableName.getName() + " ORDER BY " + orderColumn;
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    public <T> List<T> getAll(Class<T> tableName) {
        String hql = " FROM " + tableName.getName();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    public <T> List<T> getAllByPrototype(Class<T> tableName, String prototypeName, Object value) {
        String hql = " FROM " + tableName.getName() + " t WHERE t." + prototypeName + " = ? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, value);
        return query.list();
    }

    /**
     * @param id        : id cua table
     * @param tableName : table's name
     * @return : doi tuong theo id
     * @todo : find Object by id
     */
    public <T> T get(Class<T> tableName, String IDname, Long id) {
        String hql = " FROM " + tableName.getName() + " t WHERE t." + IDname + " = ? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        return (T) query.uniqueResult();
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Save to DB">
    public void save(Object objToSave) {
        getSession().save(objToSave);
    }

    public void upadte(Object objToUpdate) {
        getSession().update(objToUpdate);
    }

    public void saveOrUpdate(Object obj) {
        getSession().saveOrUpdate(obj);
    }

    public void remove(Object obj) {
        getSession().remove(obj);
    }
    // </editor-fold>
}

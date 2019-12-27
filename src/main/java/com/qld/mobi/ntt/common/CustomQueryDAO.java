package com.qld.mobi.ntt.common;

import org.hibernate.SQLQuery;

public interface CustomQueryDAO<T> {
    String select();

    String from();

    String where(T obj);

    String group();

    void setParam(SQLQuery sqlQuery, T obj);

    void addScalar(SQLQuery sqlQuery);
}

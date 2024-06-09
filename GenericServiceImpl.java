package org.marylin.Services;

import org.hibernate.SessionFactory;
import org.marylin.dao.GenericDaolmpl;
import org.marylin.dao.IGenericDAO;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GenericServiceImpl<T> implements IGenericService<T> {

    private IGenericDAO<T> dao;
    private Class<T> cl;
    SessionFactory session;

    public GenericServiceImpl(Class<T> cl, SessionFactory sessionFactory) {
        this.cl = cl;
        dao = (IGenericDAO<T>) new GenericDaolmpl<>(cl, sessionFactory);
        session = sessionFactory;
    }

    @Override
    public T get(Class<T> cl, Integer id) {
        return null;
    }

    @Override
    public T get(Class<T> cl, Long id) {
        return null;
    }

    @Override
    public T save(T object) {
        return null;
    }

    @Override
    public void update(T object) {

    }

    @Override
    public void delete(T object) {

    }

    @Override
    public List<T> query(String hsql, Map<String, Objects> params) {
        return List.of();
    }

    @Override
    public List<T> getAll() {
        return List.of();
    }
}

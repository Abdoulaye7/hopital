package com.mycompany.hopital.dantec.repository;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

public class RoleRepositoryImpl {

    public void create(Role role){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(role);
        System.out.println("Role crée");
    }
    public Role getById(Long id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Role role = session.get(Role.class,id);
        System.out.println("Role lu");

        return  role;
    }

    public Role getByName(String roleName) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Role> query = session.createQuery("FROM Role WHERE name = :roleName", Role.class);
        query.setParameter("roleName", roleName);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}

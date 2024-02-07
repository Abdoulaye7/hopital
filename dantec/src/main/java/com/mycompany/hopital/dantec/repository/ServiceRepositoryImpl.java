package com.mycompany.hopital.dantec.repository;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Service;
import com.mycompany.hopital.dantec.entity.Specialite;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceRepositoryImpl {

    public void create(Service service){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(service);

        System.out.println("Service créé");
    }

    public Service getById(int id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Service service =session.get(Service.class,id);
        System.out.println("Service Lue");

        return service;
    }

    public List<Service> list(){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Service> query =session.createQuery("select s from Service s",Service.class);
        List<Service> services=query.getResultList();
        System.out.println("Services lues");
        return services;
    }
}

package com.mycompany.hopital.dantec.repository;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Specialite;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SpecialiteRepositoryImpl {

    public void create(Specialite specialite){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(specialite);

        System.out.println("Spécialité créée");
    }

    public Specialite getById(int id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         Specialite specialite =session.get(Specialite.class,id);
        System.out.println("Specialite Lue");

        return specialite;
    }
    public void delete(int id){
        Specialite specialite=getById(id);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(specialite);

    }

    public List<Specialite> list(){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Specialite> query =session.createQuery("select s from Specialite s",Specialite.class);
        List<Specialite> specialites=query.getResultList();
        System.out.println("Specialites lues");
        return specialites;
    }

    public List<Specialite> listParId(int id){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Specialite> query =session.createQuery("select s from Specialite s where s.id=?0",Specialite.class);
        query.setParameter(0,id);
        List<Specialite> specialites=query.getResultList();
        System.out.println("Specialité lue");
        return specialites;
    }
}


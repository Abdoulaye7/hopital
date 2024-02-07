package com.mycompany.hopital.dantec.repository;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Consultation;
import com.mycompany.hopital.dantec.entity.Patient;
import com.mycompany.hopital.dantec.entity.Specialite;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ConsultationRepositoryImpl {

    public void create(Consultation consultation){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(consultation);

        System.out.println("Consultation créée");
    }

    public Consultation getById(Long id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         Consultation consultation  =session.get(Consultation.class,id);
        System.out.println("Consultation Lue");

        return consultation;
    }
    public void update(Consultation consultation)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.update(consultation);
    }
    public void delete(Long id)
    {
        Consultation consultation=getById(id);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(consultation);

    }

    public List<Consultation> list()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Consultation> query=session.createQuery("select c from Consultation c",Consultation.class);
        List<Consultation> consultations = query.getResultList();
        System.out.println("Consultation lues");

        return consultations;
    }
}

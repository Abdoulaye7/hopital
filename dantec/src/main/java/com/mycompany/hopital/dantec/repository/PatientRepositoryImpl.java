package com.mycompany.hopital.dantec.repository;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PatientRepositoryImpl {

    public void create(Patient patient){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(patient);

        System.out.println("Patient créée");
    }

    public Patient getById(int id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         Patient patient =session.get(Patient.class,id);
        System.out.println("Patient Lue");

        return patient;
    }

    public  void update(Patient patient)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.update(patient);
    }
    public List<Patient> liste()
    {
        Session  session= HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Patient> query = session.createQuery("select p from Patient p",Patient.class);
        List<Patient> patients = query.getResultList();
        System.out.println("Patients lus");
        return  patients;
    }

    public void delete(int id)
    {
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Patient patient =getById(id);
        session.delete(patient);
    }
}

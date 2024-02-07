package com.mycompany.hopital.dantec.service;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Patient;
import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.repository.PatientRepositoryImpl;
import com.mycompany.hopital.dantec.repository.SpecialiteRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

   private PatientRepositoryImpl patientRepository;

    public PatientService(){
        this.patientRepository = new PatientRepositoryImpl();
    }

    public void createPatient(Patient patient){

        Session session=null;
        Transaction tx=null;
        try {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             tx=session.beginTransaction();
            patientRepository.create(patient);
             tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();

            }
        }

    }

    public Patient getPatient(int id){
        Session session=null;
        Transaction tx=null;
        Patient patient=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            patient = patientRepository.getById(id);
            tx.commit();
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();

            }
        }
        return  patient;
    }

    public void updatePatient(Patient patient){

        Session session=null;
        Transaction tx=null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            patientRepository.update(patient);
            tx.commit();
            System.out.println("Patient modifié");
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();

            }
        }
    }
    public void deletePatient(int id){

        Session session=null;
        Transaction tx=null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            patientRepository.delete(id);
            tx.commit();
            System.out.println("Patient supprimé");
        } catch (Exception e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();

            }
        }
    }



    public List<Patient> getListePatient(){
        Session session=null;
        Transaction tx=null;
        List<Patient> patients = new ArrayList<Patient>();


        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            patients.addAll(patientRepository.liste());

        } catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }

        return patients;
    }
}

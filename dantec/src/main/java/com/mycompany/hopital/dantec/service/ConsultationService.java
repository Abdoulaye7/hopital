package com.mycompany.hopital.dantec.service;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Consultation;
import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.repository.ConsultationRepositoryImpl;
import com.mycompany.hopital.dantec.repository.SpecialiteRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ConsultationService {

   private ConsultationRepositoryImpl consultationRepository;

    public ConsultationService(){
        this.consultationRepository = new ConsultationRepositoryImpl();
    }

    public void createConsultation(Consultation consultation){

        Session session=null;
        Transaction tx=null;
        try {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             tx=session.beginTransaction();
            consultationRepository.create(consultation);
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

    public Consultation getConsultation(Long id){
        Session session=null;
        Transaction tx=null;
        Consultation consultation=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            consultation = consultationRepository.getById(id);
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
        return  consultation;
    }
    public void deleteConsultation(Long id){

        Session session=null;
        Transaction tx=null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            consultationRepository.delete(id);
            tx.commit();
            System.out.println("Consultation supprimee");
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

    public void updateConsultation(Consultation consultation){


        Session session=null;
        Transaction tx=null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            consultationRepository.update(consultation);
            tx.commit();
            System.out.println("Consultation modifié");
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

    public List<Consultation> getListeConsultation(){
        Session session=null;
        Transaction tx=null;
        List<Consultation> consultations = new ArrayList<Consultation>();


        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            consultations.addAll(consultationRepository.list());

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

        return consultations;
    }
}

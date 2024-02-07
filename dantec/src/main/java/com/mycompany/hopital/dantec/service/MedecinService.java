package com.mycompany.hopital.dantec.service;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.repository.MedecinRepositoryImpl;
import com.mycompany.hopital.dantec.repository.SpecialiteRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MedecinService {

   private MedecinRepositoryImpl medecinRepository;

    public MedecinService(){
        this.medecinRepository = new MedecinRepositoryImpl();
    }

    public void createMedecin(Medecin medecin){

        Session session=null;
        Transaction tx=null;
        try {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             tx=session.beginTransaction();
            medecinRepository.create(medecin);
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

    public Medecin getMedecin(Long id){
        Session session=null;
        Transaction tx=null;
        Medecin medecin=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            medecin = medecinRepository.getById(id);
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
        return  medecin;
    }

    public void deleteMedecin(Long id){

        Session session=null;
        Transaction tx=null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            medecinRepository.delete(id);
            tx.commit();
            System.out.println("Medecin supprimé");
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

    public void updateMedecin(Medecin medecin){


        Session session=null;
        Transaction tx=null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
             medecinRepository.update(medecin);
            tx.commit();
            System.out.println("Medecin modifié");
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
    public List<Medecin> getListeMedecin(){
        Session session=null;
        Transaction tx=null;
        List<Medecin> medecins = new ArrayList<Medecin>();


        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            medecins.addAll(medecinRepository.list());

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

        return medecins;
    }

    public List<Medecin> getListeMedecinParMat(String mat){
        Session session=null;
        Transaction tx=null;
        List<Medecin> medecins = new ArrayList<Medecin>();


        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            medecins.addAll(medecinRepository.listMedecinMat(mat));

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

        return medecins;
    }
}

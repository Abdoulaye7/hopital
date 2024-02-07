package com.mycompany.hopital.dantec.service;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.repository.SpecialiteRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SpecialiteService {

   private SpecialiteRepositoryImpl specialiteRepository;

    public SpecialiteService(){
        this.specialiteRepository = new SpecialiteRepositoryImpl();
    }

    public void createSpecialite(Specialite specialite){

        Session session=null;
        Transaction tx=null;
        try {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             tx=session.beginTransaction();
             specialiteRepository.create(specialite);
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

    public Specialite getSpecialite(int id){
        Session session=null;
        Transaction tx=null;
        Specialite specialite=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            specialite = specialiteRepository.getById(id);
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
        return  specialite;
    }

    public void deleteSpecialite(int id){

        Session session=null;
        Transaction tx=null;

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            specialiteRepository.delete(id);
            tx.commit();
            System.out.println("Spécialité supprimée");
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

    public void renomme(int id,String nom){

        Session session=null;
        Transaction tx=null;
        Specialite specialite=getSpecialite(id);

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
           specialite.setNom(nom);
           session.merge(specialite);
            tx.commit();

            System.out.println("Spécialité modifiée");


        }catch (Exception e){
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
    }

    public List<Specialite> getListeSpecialite(){
        Session session=null;
        Transaction tx=null;
        List<Specialite> specialites = new ArrayList<Specialite>();


        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            specialites.addAll(specialiteRepository.list());

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

        return specialites;
    }

    public List<Specialite> getListeSpecialiteParId(int id){
        Session session=null;
        Transaction tx=null;
        List<Specialite> specialites = new ArrayList<Specialite>();


        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            specialites.addAll(specialiteRepository.listParId(id));

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

        return specialites;
    }
}

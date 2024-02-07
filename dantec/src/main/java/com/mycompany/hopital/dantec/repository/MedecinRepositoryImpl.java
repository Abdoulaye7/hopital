package com.mycompany.hopital.dantec.repository;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Medecin;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MedecinRepositoryImpl {

    public void create(Medecin medecin){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(medecin);

        System.out.println("Médecin créée");
    }

    public Medecin getById(Long id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         Medecin medecin =session.get(Medecin.class,id);
        System.out.println("Médecin Lue");

        return medecin;
    }

    public void delete(Long id){
        Medecin medecin=getById(id);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(medecin);

    }

    public void update(Medecin medecin){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.update(medecin);
    }
    public List<Medecin> list(){

        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Query <Medecin>query = session.createQuery("select m from Medecin m",Medecin.class);
        List<Medecin> medecins = query.getResultList();
        System.out.println("Medecins lus");
        return medecins;
    }

    public List<Medecin> listMedecinMat(String mat){

        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Medecin> query = session.createQuery("select m from Medecin m where m.matricule=?0",Medecin.class);
        query.setParameter(0,mat);
        List<Medecin> medecins = query.getResultList();
        System.out.println("Medecins lus");
        return medecins;
    }

}

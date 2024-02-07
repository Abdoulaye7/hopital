package com.mycompany.hopital.dantec.service;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Service;
import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.repository.ServiceRepositoryImpl;
import com.mycompany.hopital.dantec.repository.SpecialiteRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ServiceMedecin {

   private ServiceRepositoryImpl serviceRepository;

    public ServiceMedecin(){
        this.serviceRepository = new ServiceRepositoryImpl();
    }

    public void createService(Service service){

        Session session=null;
        Transaction tx=null;
        try {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             tx=session.beginTransaction();
            serviceRepository.create(service);
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
    public Service getService(int id){
        Session session=null;
        Transaction tx=null;
        Service service=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            service = serviceRepository.getById(id);
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
        return  service;
    }

    public List<Service> getListeService(){
        Session session=null;
        Transaction tx=null;
        List<Service> services = new ArrayList<Service>();


        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            services.addAll(serviceRepository.list());

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

        return services;
    }
}

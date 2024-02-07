package com.mycompany.hopital.dantec.service;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Consultation;
import com.mycompany.hopital.dantec.entity.Role;
import com.mycompany.hopital.dantec.repository.ConsultationRepositoryImpl;
import com.mycompany.hopital.dantec.repository.RoleRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoleService {

   private RoleRepositoryImpl roleRepository;

    public RoleService(){
        this.roleRepository = new RoleRepositoryImpl();
    }

    public void createRole(Role role){

        Session session=null;
        Transaction tx=null;
        try {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             tx=session.beginTransaction();
            roleRepository.create(role);
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

    public Role getRole(Long id){
        Session session=null;
        Transaction tx=null;
        Role role=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            role = roleRepository.getById(id);
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
        return  role;
    }

    public Role getRoleByName(String roleName) {
        Session session = null;
        Transaction tx = null;
        Role role = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            role = roleRepository.getByName(roleName);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return role;
    }
}



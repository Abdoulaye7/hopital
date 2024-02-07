package com.mycompany.hopital.dantec.service;

import com.mycompany.hopital.dantec.HibernateUtil;
import com.mycompany.hopital.dantec.entity.Role;
import com.mycompany.hopital.dantec.entity.User;
import com.mycompany.hopital.dantec.repository.RoleRepositoryImpl;
import com.mycompany.hopital.dantec.repository.UserRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService {

   private UserRepositoryImpl userRepository;
   private RoleRepositoryImpl roleRepository;
   private BCryptPasswordEncoder passwordEncoder;

    public UserService(){
        this.userRepository = new UserRepositoryImpl();
        this.passwordEncoder = new BCryptPasswordEncoder();

    }

    public void createUser(User user){

        Session session=null;
        Transaction tx=null;
        try {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             tx=session.beginTransaction();
             String encodedPassword = passwordEncoder.encode(user.getPassword());
             user.setPassword(encodedPassword);
            userRepository.create(user);
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
    public boolean authenticateUser(String enteredPassword, User user) {
        return passwordEncoder.matches(enteredPassword, user.getPassword());
    }

    public User getUser(Long id){
        Session session=null;
        Transaction tx=null;
        User user=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            user = userRepository.getById(id);
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
        return  user;
    }

    public User getUserByEmail(String email) {
        Session session = null;
        Transaction tx = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            user = userRepository.getByEmail(email);

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
        return user;
    }

    public void modifierUser(User user){

        Session session=null;
        Transaction tx=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            userRepository.update(user);
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
    public void assignRole(User user, Role role){

        Session session=null;
        Transaction tx=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            Role persistedRole = roleRepository.getByName(role.getName());
            if (persistedRole == null) {
                // Si le rôle n'existe pas, persistez-le
                session.persist(role);
            } else {
                // Si le rôle existe déjà dans la base de données, utilisez-le
                role = persistedRole;
            }
            user.getRoles().add(role);
            userRepository.update(user);
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

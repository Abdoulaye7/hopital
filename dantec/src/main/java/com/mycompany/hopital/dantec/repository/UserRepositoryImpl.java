    package com.mycompany.hopital.dantec.repository;

    import com.mycompany.hopital.dantec.HibernateUtil;
    import com.mycompany.hopital.dantec.entity.Role;
    import com.mycompany.hopital.dantec.entity.User;
    import org.hibernate.Session;
    import org.hibernate.query.Query;

    import javax.persistence.NoResultException;

    public class UserRepositoryImpl {

        public void create(User user){

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.persist(user);
            System.out.println("User crée");
        }
        public User getById(Long id){
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            User user = session.get(User.class,id);
            System.out.println("User lu");

            return  user;
        }

        public void update(User user) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.merge(user);
            System.out.println("User mis à jour");
        }

        public User getByEmail(String email) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            // Utilisation de HQL pour sélectionner l'utilisateur par e-mail
            Query<User> query = session.createQuery("FROM User WHERE username = :email", User.class);
            query.setParameter("email", email);

            try {
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            }
        }


    }

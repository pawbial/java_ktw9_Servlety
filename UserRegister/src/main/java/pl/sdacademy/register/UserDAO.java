package pl.sdacademy.register;


import javax.inject.Singleton;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Singleton
public class UserDAO {

    @PersistenceContext (unitName = "testPersistenceUnit")
    private EntityManager entityManager;

    @Transactional
    void saveUser (User user) {
        entityManager.persist(user);
    }

    Collection <User> getUsers () {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    User getUser (Long userID) {
       return entityManager.find(User.class, userID);
    }

    User getUserByLastName (String lastName) {
        try {
            Query query = entityManager.createQuery("SELECT u FROM  User u WHERE u.lastName = :lastName");
            query.setParameter("lastName",lastName);

            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    User getUserByUserName (String userName) {
        try {
            Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.userName = :userName");
            query.setParameter("userName",userName);

            return (User) query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    void mergeUser (User user) {
        entityManager.merge(user);
    }
}

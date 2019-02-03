package pl.sdacademy.register;


import javax.ejb.Singleton;
import javax.persistence.EntityManager;
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
}

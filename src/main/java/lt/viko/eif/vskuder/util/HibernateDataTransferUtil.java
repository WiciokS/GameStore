package lt.viko.eif.vskuder.util;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * HibernateDataTransferUtil class
 * <p>
 * This class is used to transfer data to and from database
 * </p>
 */
public class HibernateDataTransferUtil {
    /**
     * This method is used to add data to database
     *
     * @param objectToAdd object to add to database
     */

    public static void addData(Object objectToAdd) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(objectToAdd);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * This method is used to update data in database
     *
     * @param entityType object to update in database
     * @param session    session to use
     * @param <T>        type of object
     * @return list of objects
     */

    public static <T> List<T> getAllData(Class<T> entityType, Session session) {
        List<T> entities = null;
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(entityType);
            Root<T> root = query.from(entityType);
            query.select(root);
            List<T> gameStores = session.createQuery(query).getResultList();
            entities = gameStores;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }
}

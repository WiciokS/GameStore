package lt.viko.eif.vskuder;

import lt.viko.eif.vskuder.model.GameStore;
import lt.viko.eif.vskuder.util.HibernateDataTransferUtil;
import lt.viko.eif.vskuder.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
/**
 * The main class of the program. This class is used to get data from database and print it to console.
 */

public class MainSqlget {
    /**
     * The main method of the program.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<GameStore> gameStores = HibernateDataTransferUtil.getAllData(GameStore.class, session);
            for (GameStore gameStore1 : gameStores) {
                System.out.println(gameStore1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

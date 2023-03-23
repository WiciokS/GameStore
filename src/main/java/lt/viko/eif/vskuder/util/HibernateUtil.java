package lt.viko.eif.vskuder.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 * HibernateUtil class
 * @author vskuder
 * version 1.0
 */

public class HibernateUtil {
    /**
     * StandardServiceRegistry registry
     */
    private static StandardServiceRegistry registry;
    /**
     * SessionFactory sessionFactory
     */
    private static SessionFactory sessionFactory = null;
    /**
     * HibernateUtil constructor
     */

    private HibernateUtil()
    {
    }
    /**
     * getSessionFactory method
     * @return sessionFactory
     */

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata setData = sources.getMetadataBuilder().build();
                sessionFactory = setData.getSessionFactoryBuilder().build();

            }catch (Exception e){
                e.printStackTrace();
                shutdown();
            }
        }
        return sessionFactory;
    }
    /**
     * shutdown method
     */
    public static void shutdown(){
        if(registry != null){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}

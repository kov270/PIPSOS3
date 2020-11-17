import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PointUnit");
    public static EntityManager em = entityManagerFactory.createEntityManager();
}

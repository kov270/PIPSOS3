import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "Results", eager = true)
@SessionScoped
public class ResultsBean {

    public List<Point> getPoints() {
        Database.em.getTransaction().begin();
        List<Point> list = Database.em.createQuery("SELECT c FROM Point c", Point.class).getResultList();
        Database.em.getTransaction().commit();
        return list;
    }

}

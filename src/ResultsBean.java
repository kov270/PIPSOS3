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
        this.points = Database.em.createQuery("SELECT c FROM Point c", Point.class).getResultList();
        Database.em.getTransaction().commit();
        return this.points;
    }

    public List<Point> filteredPoints;

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public List<Point> points;

    public List<Point> getFilteredPoints() {
        return filteredPoints;
    }

    public void setFilteredPoints(List<Point> filteredPoints) {
        this.filteredPoints = filteredPoints;
    }
}

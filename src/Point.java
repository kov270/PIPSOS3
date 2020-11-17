import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double x;
    private Double y;
    private Double r;
    private Boolean result;

    public Point(Double x, Double y, Double r, Boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }

    public String getX() {
        return String.format("%.2f", x);
    }

    public void setX(Double x) {
        this.x = x;
    }

    public String getY() {
        return String.format("%.2f", y);
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getR() {
        return String.format("%.2f", r);
    }

    public void setR(Double r) {
        this.r = r;
    }

    public String getResult() {
        return result ? "Yes" : "No";
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Point() {
        x = 0.;
        y = 0.;
        r = 0.;
        result = true;
    }

    void save() {
        Database.em.getTransaction().begin();
        Database.em.persist(this);
        Database.em.getTransaction().commit();
    }

    static Boolean calculate(Double x, Double y, Double r) {
        if (x >= 0 && y >= 0 && x*x + y*y <= r*r)
            return true;
        else if (x <= 0 && y >= 0 && y <= r && x >= -r/2)
            return true;
        else if (x >= 0 && y <= 0 && y >= x - r)
            return true;
        else
            return false;
    }
}

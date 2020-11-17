import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;

@ManagedBean(name = "Worker", eager = true)
@SessionScoped
public class WorkBean implements Serializable {

    private Double x;
    private Double y;
    private Double r;

    private Boolean inArea;


    public WorkBean() {
        this.x = 0.;
        this.y = 0.;
        this.r = 1.;
        this.inArea = false;
    }

    public void onSubmit() {
        inArea = Point.calculate(x, y, r);
        Point point = new Point(x, y, r, inArea);
        point.save();
    }

    public void onYChecked(Double value) {
        this.y = value;
    }

    public void onRClicked(Integer value) {
        if (Arrays.asList(1, 2, 3, 4, 5).contains(value))
            this.r = value + 0.;
    }


    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public String go() {
        return "success";
    }

    public String back() {
        return "success";
    }
}

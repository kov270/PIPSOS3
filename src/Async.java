import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebServlet("/async")
public class Async extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            Double x = Double.parseDouble(request.getParameter("x"));
            Double y = Double.parseDouble(request.getParameter("y"));
            Double r = Double.parseDouble(request.getParameter("r"));
            Boolean inArea = Point.calculate(x, y, r);
            Point point = new Point(x, y, r, inArea);
            point.save();
            writer.print(String.format(Locale.US, "{\"x\":%.2f, \"y\":%.2f, \"r\":%.2f, \"inArea\":%s}", x, y, r, inArea ? "true" : "false"));
        } catch (Exception e) {
            writer.print("fail");
        } finally {
            writer.flush();
            writer.close();
        }
    }

}
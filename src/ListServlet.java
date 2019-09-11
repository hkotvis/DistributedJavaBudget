import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String DATABASE_PATH = "/WEB-INF/lib/budget";
    private final String USER = "hailey";
    private final String PW = "hailey";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt  = null;
        ResultSet rset = null;

        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String path = getServletContext().getRealPath(DATABASE_PATH);
            // Create the connection
            conn = DriverManager.getConnection(DRIVER_NAME + path, USER, PW);
            stmt = conn.createStatement();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ExpenseName FROM Expenses ");
            sql.append("ORDER BY ExpenseName");

            rset = stmt.executeQuery(sql.toString());
            StringBuilder html = new StringBuilder("<html><body><ul>");
            while(rset.next()){
                String petName = rset.getString("ExpenseName");
                html.append("<li>").append(petName).append("</li>");
            }
            html.append("</ul></body></html>");
            response.getWriter().print(html.toString());

        }catch (ClassNotFoundException | SQLException e){
            response.getWriter().print(e.getMessage());
        }finally{
            if(rset != null){
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rset != null){
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

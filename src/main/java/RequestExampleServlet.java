import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RequestExampleServlet", urlPatterns = "/request-example")

public class RequestExampleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int age =  Integer.parseInt(request.getParameter("age"));
        out.println("Form submitted with an age value of: " + age);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        String pageMessage;
        if ((request.getParameter("page") != null)) {
            pageMessage = request.getParameter("page");
            out.println("You are on page: " + pageMessage);
        } else {
            response.sendRedirect("/request-example?page=1");
            return;
        }


        out.println("<form method='POST'><input type='text' name='age' placeholder='enter age'><button>Submit</button></form>");


    }
}

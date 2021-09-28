package co.edu.unbosque.cookiestutorial;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "cookieServlet", value = "/cookie-servlet")
public class CookieServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Cookie cookie = new Cookie("username", "pepito");
        cookie.setMaxAge(20);
        response.addCookie(cookie);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<meta http-equiv='refresh' content='10; URL=form.html'>");
        out.println("</head><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
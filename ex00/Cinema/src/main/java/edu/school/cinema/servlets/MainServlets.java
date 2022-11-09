package edu.school.cinema.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class MainServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            PrintWriter pw = resp.getWriter();
            pw.println("<html>");
            pw.println("<h1> Hello, " + name + " " +    surname + "! </h1>");
            pw.println("</html>");
    }

}

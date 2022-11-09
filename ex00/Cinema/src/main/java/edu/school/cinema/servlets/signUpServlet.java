package edu.school.cinema.servlets;

import edu.school.cinema.model.User;
import edu.school.cinema.services.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class signUpServlet extends HttpServlet {

    private UsersService usersService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context  = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context
                .getAttribute("springContext");
        this.usersService = springContext.getBean(UsersService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        if (usersService.signUp(new User(firstName, lastName, phone, password))) {
            req.getSession().setAttribute("auth", 1);
            resp.sendRedirect("/signIn");
        } else {
            req.getSession().setAttribute("retry", 1);
            req.getSession().setAttribute("firstname", firstName);
            req.getSession().setAttribute("lastname", lastName);
            req.getSession().setAttribute("phone", phone);
            resp.sendRedirect("/signUp");
        }
    }
}

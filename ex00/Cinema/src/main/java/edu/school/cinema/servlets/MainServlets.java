package edu.school.cinema.servlets;

import edu.school.cinema.test.Cart;

import javax.servlet.RequestDispatcher;
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
        HttpSession session = req.getSession();

//        String user = (String) session.getAttribute("current_user");
//        if (user == null) {
//            // resp для анонимного пользователя
//            // авторизация/регистрация пользователя
//            // session.setAttribute("current_user", ID);
//        } else {
//            // resp для авторизованного пользователя
//        }

        Cart cart = (Cart) session.getAttribute("cart");
        String name = req.getParameter("name");
        Integer quantity = Integer.parseInt(req.getParameter("quantity"));
        if (cart == null) {
          cart = new Cart(name, quantity);
        }
        session.setAttribute("cart", cart);


        getServletContext().getRequestDispatcher("/showCart.jsp").forward(req, resp);

//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");

//        PrintWriter pw = resp.getWriter();
//        pw.println("<html>");
//        pw.println("<h1> Your count is  "  + "! </h1>");
//        pw.println("</html>");

//        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
//        dispatcher.forward(req, resp);
    }

}

package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Order", value = "/order")
public class Order extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp?order=true");
        } else {
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
            request.getRequestDispatcher("WEB-INF/order.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
        try {
        int res = Orderfacade.createOrder(user.getId(), connectionPool);
            OrderItemFacade.createOrderItems(res, shoppingCart.getOrder(), connectionPool);
            UserFacade.subtractBalance(user, shoppingCart.getTotalPrice(), connectionPool);
            user = UserFacade.login(user.getEmail(), user.getPassword(), connectionPool);
            session.setAttribute("user", user);
            request.setAttribute("shoppingcart", shoppingCart);
            session.removeAttribute("shoppingcart");
            request.getRequestDispatcher("WEB-INF/receipt.jsp").forward(request, response);

        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }


    }
}

package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;

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
            response.sendRedirect("login?order=true");
        } else {
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
            int sum = 0;
            for (int i = 0; i < shoppingCart.cupcakeList.size(); i++) {
                sum += shoppingCart.cupcakeList.get(i).getTop().getPrice() + shoppingCart.cupcakeList.get(i).getBottom().getPrice();
            }
            System.out.println(sum);
            request.setAttribute("sum", sum);
            request.getRequestDispatcher("WEB-INF/order.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}

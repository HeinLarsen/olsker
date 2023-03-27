package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeFacade;
import dat.backend.model.persistence.OrderItemMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCart", value = "/addtocart")
public class AddToCart extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
        User user = (User) session.getAttribute("user");

        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.addOrder(new Order(user));
        }
        if (shoppingCart.getOrder() == null) {
            shoppingCart.addOrder(new Order(user));
        }


        int topId = Integer.parseInt(request.getParameter("top"));

        int bottomId = Integer.parseInt(request.getParameter("bottom"));

        int quantity = Integer.parseInt(request.getParameter("quantity"));


        ServletContext applicationScope = getServletContext();
        List<Top> toppingList = (List<Top>) applicationScope.getAttribute("toppingList");
        List<Bottom> bottomList = (List<Bottom>) applicationScope.getAttribute("bottomList");


        Top top = null;
        Bottom bottom = null;

        for (Top t : toppingList) {
            if (t.getId() == topId) {
                top = t;
            }
        }

        for (Bottom b : bottomList) {
            if (b.getId() == bottomId) {
                bottom = b;
            }
        }
        System.out.println(top);

        OrderItem orderItem = new OrderItem(top, bottom, quantity);
        shoppingCart.getOrder().addItem(orderItem);
        session.setAttribute("shoppingcart", shoppingCart);
//        session.setAttribute("cartsize", shoppingCart.getOrder().getOrderItems().size());
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }


}

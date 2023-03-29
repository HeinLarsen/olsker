package dat.backend.control;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.ShoppingCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updateQuantity", value = "/updatequantity")
public class updateQuantity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
        System.out.println(shoppingCart.getOrder());

        int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
        String action = request.getParameter("action");

        OrderItem item = shoppingCart.getOrder().getOrderItems().get(itemIndex);
        if ("increment".equals(action)) {
            item.setQuantity(item.getQuantity() + 1);
        } else if ("decrement".equals(action)) {
            item.setQuantity(item.getQuantity() - 1);
        }
        // delete orderItem from order if quantity is 0
        if (item.getQuantity() == 0) {
            shoppingCart.getOrder().getOrderItems().remove(itemIndex);
        }

        session.setAttribute("shoppingcart", shoppingCart);

        response.sendRedirect("index.jsp");
    }
}

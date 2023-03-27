package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderItemFacade;
import dat.backend.model.persistence.Orderfacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowOrders", value = "/showorders")
public class ShowOrders extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        try {
            if(u != null && u.getRole() == 2) {
                List<Order> orderList = Orderfacade.showOrders(connectionPool);
                List<OrderItem> orderItems = OrderItemFacade.getOrderItems(connectionPool);
                for (Order o : orderList) {
                    for (OrderItem oi : orderItems) {
                        if (o.getId() == oi.getOrderId()) {
                            System.out.println(oi.getOrderId() + " " + o.getId());
                            o.addItem(oi);
                        }
                    }
                }
                request.setAttribute("orderList", orderList);
                request.getRequestDispatcher("WEB-INF/showorders.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        OrderItem orderItem = (OrderItem) session.getAttribute("orderitem");


    }
}

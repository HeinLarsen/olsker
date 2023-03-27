package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderItemFacade;
import dat.backend.model.persistence.OrderItemMapper;
import dat.backend.model.persistence.Orderfacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowAllOrderItemsByOrderId", value = "/showallorderitemsbyorderid")
public class ShowAllOrderItemsByOrderId extends HttpServlet {
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
                    int userId = u.getId(); // Get the ID of the currently logged in user
                    List<Order> orderList = Orderfacade.showOrders(connectionPool);
                    List<OrderItem> orderItemsList = OrderItemFacade.getAllOrderItemsByOrderId(userId, connectionPool);
                    for (Order o : orderList) {
                        if (o.getId() == userId) { // Only consider orders that belong to the current user
                            for (OrderItem oi : orderItemsList) {
                                if (o.getId() == oi.getOrderId()) {
                                    System.out.println(oi.getOrderId() + " " + o.getId());
                                    o.addItem(oi);
                                }
                            }
                        }
                    }
                    request.setAttribute("orderItemsList", orderList);
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

    }
}

package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowOrders", value = "/showorders")
public class ShowOrders extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        if(u != null && u.getRole() == 2){
            List<Order> orderItemViewList = OrderFacade.ShowOrders(connectionPool);
            request.setAttribute("orderListView", orderItemViewList);
            request.getRequestDispatcher("WEB-INF/showorders.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Order_Item_View order_item_view = (Order_Item_View) session.getAttribute("order_item_view");


    }
}

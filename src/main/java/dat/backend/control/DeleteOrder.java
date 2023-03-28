package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderItemFacade;
import dat.backend.model.persistence.Orderfacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteOrder", value = "/deleteorder")
public class DeleteOrder extends HttpServlet {
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

        int orderId = Integer.parseInt(request.getParameter("id"));

        try {
            OrderItemFacade.deleteOrderItemByOrderId(orderId, connectionPool);
            Orderfacade.deleteOrderById(orderId, connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        String uri = request.getHeader("referer");
        // extract the last part of the URI (after the last '/')
        String page = uri.substring(uri.lastIndexOf('/') + 1);
        System.out.println(page);
        // redirect to the previous page
        response.sendRedirect(page);



    }
}

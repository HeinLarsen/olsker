package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddToCart", value = "/addtocart")
public class AddToCart extends HttpServlet {
    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO: create persistence: CupcakeFacade to get this working! & create CupcakeMapper as well!
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        int topId = Integer.parseInt(request.getParameter("topId"));
        int bottomId = Integer.parseInt(request.getParameter("bottomId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ArrayList<Top> top = new ArrayList<>();
        try {
            top = CupcakeFacade.getTopById(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        ArrayList<Bottom> bottom = new ArrayList<>();
        try {
            bottom = CupcakeFacade.getBottomById(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        Cupcake cupcake = new Cupcake(top, bottom, quantity);
        cart.add(cupcake);
        session.setAttribute("cart", cart);
        request.setAttribute("cartsize", cart.GetNumberOfCupcakes());
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);


    }


}

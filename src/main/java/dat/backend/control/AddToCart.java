package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Top;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCart", value = "/addtocart")
public class AddToCart extends HttpServlet {
    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO: create persistence: CupcakeFacade to get this working!
      /*  HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        int topId = Integer.parseInt(request.getParameter("topId"));
        int bottomId = Integer.parseInt(request.getParameter("bottomId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Top top = CupcakeFacade.getTopById(topId, connectionPool);
        Bottom bottom = CupcakeFacade.getBottomById(bottomId, connectionPool);

        Cupcake cupcake = new Cupcake(top, bottom, quantity);
        cart.add(cupcake);
        session.setAttribute("cart", cart);
        request.setAttribute("cartsize", cart.GetNumberOfCupcakes());
request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);*/




    }
}

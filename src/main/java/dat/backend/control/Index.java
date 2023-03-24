package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Index", value = "/index")
public class Index extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");

        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            session.setAttribute("shoppingCart", shoppingCart);
        }

        try {
            ServletContext applicationScope = getServletContext();
            List<Top> toppingList = (List<Top>) applicationScope.getAttribute("toppingList");
            if (toppingList == null)
            {
                toppingList = CupcakeFacade.getToppings(connectionPool);
                applicationScope.setAttribute("toppingList", toppingList);
            }
            List<Bottom> bottomList = (List<Bottom>) applicationScope.getAttribute("bottomList");
            if (bottomList == null)
            {
                bottomList = CupcakeFacade.getBottoms(connectionPool);
                applicationScope.setAttribute("bottomList", bottomList);
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

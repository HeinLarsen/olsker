package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveBalance", value = "/removebalance")
public class RemoveBalance extends HttpServlet
{
    private  ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int userid = Integer.parseInt(request.getParameter("id"));
        try {
            if (u != null && u.getRole() == 2) {

                int currentBalance = Integer.parseInt(request.getParameter("currentBalance"));
                session.setAttribute("user", u);
                int id = Integer.parseInt(request.getParameter("id"));
                int amount = Integer.parseInt(request.getParameter("amount"));
                int newbalance = currentBalance - amount;
                UserFacade.updateBalance(id, newbalance, connectionPool);
                User user = UserFacade.getUserById(userid, connectionPool);

                request.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/balance.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    }

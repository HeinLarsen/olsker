package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.util.List;

public class Orderfacade {

    public static List<Order> showOrders(ConnectionPool connectionpool) throws DatabaseException{
       return OrderMapper.getAllOrders(connectionpool);
    }

    public static int createOrder(int id, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.createOrder(id, connectionPool);
    }

    public static List<Order> getAllOrdersByUserId(int userId, ConnectionPool connectionPool) throws DatabaseException{
        return OrderMapper.getAllOrdersByUserId(userId, connectionPool);
    }

    public static void deleteOrderById(int orderId, ConnectionPool connectionPool) throws DatabaseException {
        OrderMapper.deleteOrderById(orderId, connectionPool);
    }
}

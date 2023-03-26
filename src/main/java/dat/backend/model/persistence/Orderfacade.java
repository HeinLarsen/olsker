package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.util.List;

public class Orderfacade {

    public static List<Order> ShowOrders(ConnectionPool connectionpool){
       return OrderMapper.GetAllOrders(connectionpool);
    }

    public static int createOrder(int id, ConnectionPool connectionPool) throws DatabaseException {
        return OrderMapper.createOrder(id, connectionPool);
    }
}

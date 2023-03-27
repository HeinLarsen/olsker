package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;
import java.util.List;

public class OrderItemFacade {
    public static void createOrderItems(int res, Order order, ConnectionPool connectionPool) throws DatabaseException {
        OrderItemMapper.createOrderItems(res, order, connectionPool);
    }

    public static List<OrderItem> getOrderItems(ConnectionPool connectionPool) throws DatabaseException {
       return OrderItemMapper.getOrderItems(connectionPool);
    }
}
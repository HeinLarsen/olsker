package dat.backend.model.persistence;

import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.exceptions.DatabaseException;

public class OrderItemFacade {
    public static void createOrderItems(int res, ShoppingCart shoppingCart, ConnectionPool connectionPool) throws DatabaseException {
        OrderItemMapper.createOrderItems(res, shoppingCart, connectionPool);
    }
}

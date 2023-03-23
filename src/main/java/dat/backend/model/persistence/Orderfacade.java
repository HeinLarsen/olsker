package dat.backend.model.persistence;

import dat.backend.model.entities.Order;

import java.sql.Connection;
import java.util.List;

public class Orderfacade {

    public static List<Order> ShowOrders(ConnectionPool connectionpool){
       return OrderMapper.GetAllOrders(connectionpool);
    }
}

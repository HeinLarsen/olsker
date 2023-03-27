package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.Order_Item_View;

import java.util.List;

public class OrderFacade {

    public static List<Order> ShowOrders(ConnectionPool connectionpool){
       return OrderMapper.GetAllOrders(connectionpool);
    }
   public static List<Order_Item_View> ListAllOrdersFromView(ConnectionPool connectionpool){
        return OrderItemMapper.GetAllItemsFromView(connectionpool);
   }
}

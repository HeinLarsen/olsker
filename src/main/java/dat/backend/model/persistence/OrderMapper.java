package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static List<Order>  GetAllOrders(ConnectionPool connectionPool){
        String sql = "SELECT * FROM `order`";
        List<Order> orderList = new ArrayList<>();
        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    int user_id = rs.getInt("user_id");
                    Timestamp created = rs.getTimestamp("created");
                    Order order = new Order(id, user_id, created);
                    orderList.add(order);
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        List<OrderItem> orderItemList = OderItemMapper.GetAllItems(connectionPool);
       for(Order o : orderList){
           for(OrderItem oi : orderItemList){
               if(o.getId() == oi.getOrder_id()){
                   o.addToOrderList(oi);
               }
           }
        }
        return orderList;

    }
}

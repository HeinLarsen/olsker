package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.exceptions.DatabaseException;

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
        List<OrderItem> orderItemList = OrderItemMapper.GetAllItems(connectionPool);
       for(Order o : orderList){
           for(OrderItem oi : orderItemList){
               if(o.getId() == oi.getOrder_id()){
                   o.addToOrderList(oi);
               }
           }
        }
        return orderList;
    }

    public static int createOrder(int id, ConnectionPool connectionPool) throws DatabaseException {
        System.out.println(id);
        String sql = "INSERT INTO `order` (user_id) VALUES (?)";
        try(Connection connection = connectionPool.getConnection()) {
            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, id);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new DatabaseException(ex, "Error creating order. Something went wrong with the database");
        }
    }
}

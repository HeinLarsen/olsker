package dat.backend.model.persistence;

import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemMapper {

    public static List<OrderItem> getOrderItems(ConnectionPool connectionpool){
        String sql = "SELECT *, cupcake_top.topping, cupcake_top.price, cupcake_bottom.bottom, cupcake_bottom.price FROM olsker.order_item join cupcake_top on cupcake_top_id = cupcake_top.id join cupcake_bottom on cupcake_bottom_id = cupcake_bottom.id";
        List<OrderItem> orderItemList = new ArrayList<>();
        try(Connection connection = connectionpool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    int orderId = rs.getInt("order_id");
                    int topId = rs.getInt("cupcake_top_id");
                    int bottomId = rs.getInt("cupcake_bottom_id");
                    float cupcake_top_price = rs.getFloat("cupcake_top_price");
                    float cupcake_bottom_price = rs.getFloat("cupcake_bottom_price");
                    String topping = rs.getString("topping");
                    String bottom = rs.getString("bottom");
                    int quantity = rs.getInt("quantity");
                    OrderItem orderItem = new OrderItem(id, orderId, quantity, new Top(topId, topping, cupcake_top_price), new Bottom(bottomId, bottom, cupcake_bottom_price) );
                    orderItemList.add(orderItem);
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return orderItemList;
    }

    public static void createOrderItems(int res, Order order, ConnectionPool connectionPool) throws DatabaseException {
        String sql = "insert into order_item (order_id, cupcake_top_id, cupcake_bottom_id, cupcake_top_price, cupcake_bottom_price, quantity) values (?,?,?,?,?,?)";
        try(Connection connection = connectionPool.getConnection()) {
                for (OrderItem c : order.getOrderItems()) {
                    System.out.println(res);
                    try(PreparedStatement ps = connection.prepareStatement(sql)) {
                        ps.setInt(1, res);
                        ps.setInt(2, c.getTop().getId());
                        ps.setInt(3, c.getBottom().getId());
                        ps.setDouble(4, c.getTop().getPrice());
                        ps.setDouble(5, c.getBottom().getPrice());
                        ps.setInt(6, c.getQuantity());
                        ps.executeUpdate();
                    }
            }
        } catch(SQLException e) {
            throw new DatabaseException(e, "Could not create order");
        }
    }



}



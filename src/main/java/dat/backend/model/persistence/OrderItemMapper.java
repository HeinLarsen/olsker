package dat.backend.model.persistence;

import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemMapper {

    public static List<OrderItem> GetAllItems(ConnectionPool connectionpool){
        String sql = "SELECT * FROM order_item";
        List<OrderItem> orderItemList = new ArrayList<>();
        try(Connection connection = connectionpool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    int order_id = rs.getInt("order_id");
                    int top_id = rs.getInt("cupcake_top_id");
                    int bottom_id = rs.getInt("cupcake_bottom_id");
                    float cupcake_top_price = rs.getFloat("cupcake_top_price");
                    float cupcake_bottom_price = rs.getFloat("cupcake_bottom_price");
                    int quantity = rs.getInt("quantity");
                    OrderItem orderItem = new OrderItem(id, order_id, top_id, bottom_id, cupcake_top_price, cupcake_bottom_price, quantity);
                    orderItemList.add(orderItem);
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return orderItemList;
    }

    public static void createOrderItems(int res, ShoppingCart shoppingCart, ConnectionPool connectionPool) throws DatabaseException {
        String sql = "insert into order_item (order_id, cupcake_top_id, cupcake_bottom_id, cupcake_top_price, cupcake_bottom_price, quantity) values (?,?,?,?,?,?)";
        try(Connection connection = connectionPool.getConnection()) {
            for (Cupcake c : shoppingCart.getCupcakeList()) {
                System.out.println(res);
                System.out.println(c);
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

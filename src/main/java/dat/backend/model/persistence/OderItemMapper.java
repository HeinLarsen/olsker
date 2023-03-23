package dat.backend.model.persistence;

import dat.backend.model.entities.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OderItemMapper {

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
}

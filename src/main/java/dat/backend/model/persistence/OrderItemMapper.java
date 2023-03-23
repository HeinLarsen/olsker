package dat.backend.model.persistence;

import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.Order_Item_View;

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

    public static List<Order_Item_View> GetAllItemsFromView(ConnectionPool connectionPool){
        String sql = "SELECT * FROM order_item_view";
        List<Order_Item_View> orderItemViewList = new ArrayList<>();
        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int order_id = rs.getInt("order_id");
                    String email = rs.getString("email");
                    String cupcake_type = rs.getString("cupcake_type");
                    float total_price = rs.getFloat("total_price");
                    int quantity = rs.getInt("quantity");
                    Order_Item_View order_item_view = new Order_Item_View(order_id, email, cupcake_type, total_price, quantity);
                    orderItemViewList.add(order_item_view);
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return orderItemViewList;
    }
}

package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static List<Order> getAllOrders(ConnectionPool connectionPool) throws DatabaseException {
        String sql = "SELECT `order`.id, `order`.created,`order`.user_id, user.email, user.role, user.balance FROM `order` left join `user` on `order`.user_id = `user`.id";
        List<Order> orderList = new ArrayList<>();
        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    String email = rs.getString("email");
                    int role = rs.getInt("role");
                    double balance = rs.getDouble("balance");
                    Timestamp created = rs.getTimestamp("created");
                    Order order = new Order(id, new User(userId, email, role, balance), created);
                    orderList.add(order);
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new DatabaseException(ex, "Fejl ved hentning af ordre. Noget gik galt med databasen");
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
            throw new DatabaseException(ex, "Fejl ved oprettelse af ordre. Noget gik galt med databasen");
        }
    }

    public static List<Order> getAllOrdersByUserId(int userId, ConnectionPool connectionPool) throws DatabaseException {
        String sql = "SELECT `order`.id, `order`.created, `order`.user_id, user.email, user.role, user.balance FROM `order` left join `user` on `order`.user_id = `user`.id where user_id = ?";
        List<Order> orderList = new ArrayList<>();
        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    int role = rs.getInt("role");
                    double balance = rs.getDouble("balance");
                    Timestamp created = rs.getTimestamp("created");
                    Order order = new Order(id, new User(userId, email, role, balance), created);
                    orderList.add(order);
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new DatabaseException(ex, "Fejl ved hentning af ordre. Noget gik galt med databasen");
        }
        return orderList;
    }

    public static void deleteOrderById(int orderId, ConnectionPool connectionPool) throws DatabaseException {
        String sql ="DELETE FROM `order` WHERE id = ?";
        try(Connection connection = connectionPool.getConnection()) {
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.executeUpdate();
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new DatabaseException(ex, "Fejl ved sletning af odre. Noget gik galt med databasen");
        }
    }
}

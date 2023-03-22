package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CupcakeMapper {

    public static Top getTopById(int topId, ConnectionPool connectionPool)  {

        Top top = null;

        String sql = "SELECT * FROM top WHERE id = ?";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, topId);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    top = new Top(id, name, price);
                    return top;
                } else {
                    return null;

                }

            }
        } catch (SQLException ex){
           ex.printStackTrace();
        }
        return top;

    }


    public static Bottom getBottomById(int bottomId, ConnectionPool connectionPool)  {
        Bottom bottom = null;

        String sql = "SELECT * FROM bottom WHERE id = ?";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, bottomId);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    bottom = new Bottom(id, name, price);
                    return bottom;
                } else {
                   return null;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return bottom;
    }

}

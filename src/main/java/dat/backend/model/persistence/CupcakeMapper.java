package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CupcakeMapper {
    static List<Cupcake> getAllCupcakes(ConnectionPool connectionPool) throws DatabaseException
    {

        String sql = "SELECT * FROM olsker.order_item;";

        List<Cupcake> cupcakeList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int cupcakeId = rs.getInt("id");
                    Top cupcakeTop = rs.getString("cupcake_top");
                    Bottom cupcakeBottom = rs.getString("cupcake_bottom");

                    Cupcake newCupcake = new Cupcake(cupcakeId, cupcakeTop, cupcakeBottom);
                    cupcakeList.add(newCupcake);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

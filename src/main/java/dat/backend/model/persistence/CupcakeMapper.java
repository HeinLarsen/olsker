package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;

public class CupcakeMapper {

    static ArrayList<Top> getTopById(int topId, ConnectionPool connectionPool) throws DatabaseException {

        String sql = "SELECT * FROM cupcake_top";

        ArrayList<Top> cupcakeTop = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, topId);
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    int cupcakeId = rs.getInt("id");
                    String cupcakeName =rs.getString("name");
                    double cupcakePrice = rs.getDouble("price");
                    Top newCupcake = new Top(cupcakeId, cupcakeName, cupcakePrice);
                    cupcakeTop.add(newCupcake);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cupcakeTop;
    }

    static ArrayList<Bottom> getBottomById(int bottomId, ConnectionPool connectionPool) throws DatabaseException {

        String sql = "SELECT * FROM cupcake_bottom ";

        ArrayList<Bottom> cupcakeBottom = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, bottomId);
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    int cupcakeId = rs.getInt("id");
                    String cupcakeName =rs.getString("name");
                    double cupcakePrice = rs.getDouble("price");
                    Bottom newCupcake = new Bottom(cupcakeId, cupcakeName, cupcakePrice);
                    cupcakeBottom.add(newCupcake);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cupcakeBottom;
    }
}




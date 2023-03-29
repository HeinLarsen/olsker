package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CupcakeMapper {

    static ArrayList<Top> getToppings(ConnectionPool connectionPool) throws DatabaseException {

        String sql = "SELECT * FROM cupcake_top";

        ArrayList<Top> cupcakeTop = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    int cupcakeId = rs.getInt("id");
                    String cupcakeName =rs.getString("topping");
                    double cupcakePrice = rs.getDouble("price");
                    Top newCupcake = new Top(cupcakeId, cupcakeName, cupcakePrice);
                    cupcakeTop.add(newCupcake);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseException(e, "Kunne ikke hente cupcake toppings");
        }
        return cupcakeTop;
    }

    static ArrayList<Bottom> getBottoms(ConnectionPool connectionPool) throws DatabaseException {

        String sql = "SELECT * FROM cupcake_bottom ";

        ArrayList<Bottom> cupcakeBottom = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    int cupcakeId = rs.getInt("id");
                    String cupcakeName =rs.getString("bottom");
                    double cupcakePrice = rs.getDouble("price");
                    Bottom newCupcake = new Bottom(cupcakeId, cupcakeName, cupcakePrice);
                    cupcakeBottom.add(newCupcake);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseException(e, "Kunne ikke hente cupcake bottoms");
        }
        return cupcakeBottom;
    }
}




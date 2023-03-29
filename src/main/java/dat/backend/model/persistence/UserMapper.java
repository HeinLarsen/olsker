package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper
{
    static User login(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    int id = rs.getInt("id");
                    int balance = rs.getInt("balance");
                    int role = rs.getInt("role");
                    user = new User(id, email, password, role, balance);
                } else
                {
                    throw new DatabaseException("Forkert email eller password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl ved login. Noget gik galt med databasen");
        }
        return user;
    }

    static void createUser(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "insert into user (email, password) values (?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 0) {
                    throw new DatabaseException("Brugeren med email = " + email + " Kunne ikke blive tilføjet til databasen");
                }
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new DatabaseException(ex, "Kunne ikke indsætte bruger i databasen");
        }
    }

    static ArrayList<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int role = rs.getInt("role");
                    int balance = rs.getInt("balance");
                    User user = new User(id, email, password, role, balance);
                    users.add(user);
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Kunne ikke hente brugere fra databasen");
        }
        return users;
    }

    static User updateBalance(int id, double amount, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user = null;
        String sql = "update user SET balance = ? WHERE id = ?";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setDouble(1, amount);
                ps.setInt(2, id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {

                } else
                {
                    throw new DatabaseException("Balancen for brugeren med id = " + id + " eksisterer ikke og kunne ikke blive opdateret");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Kunne ikke opdatere balancen i databasen");
        }
        return user;
    }

    public static User getUserById(int id, ConnectionPool connectionPool) throws DatabaseException {
        String sql = "SELECT * FROM user WHERE id = ?";
        User user = null;

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int role = rs.getInt("role");
                    int balance = rs.getInt("balance");
                    user = new User(id, email, password, role, balance);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex, "Kunne ikke hente bruger fra databasen");

        }
        return user;
    }

    public static void subtractBalance(User u, double getTotalPrice, ConnectionPool connectionPool) throws DatabaseException {
        double newBalance = u.getBalance() - getTotalPrice;
        String sql = "update user SET balance = ? WHERE id = ?";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setDouble(1, newBalance);
                ps.setInt(2, u.getId());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected != 1) {
                    throw new DatabaseException("Balancen for brugeren med id = " + u.getId() + " eksisterer ikke og kunne ikke blive opdateret");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Kunne ikke opdatere balancen i databasen");
        }
    }
}
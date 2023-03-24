package dat.backend.model.persistence;

import dat.backend.model.entities.Transaction;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionMapper
{
 static Transaction getTransactionHistory(int amount, Timestamp timestamp, ConnectionPool connectionPool) throws DatabaseException
 {
     Logger.getLogger("web").log(Level.INFO, "");

     User user = null;

     String sql = "select * from olsker.transactions where user_id = ?;";

     Transaction transaction;
     try (Connection connection = connectionPool.getConnection())
     {
         try (PreparedStatement ps = connection.prepareStatement(sql))
         {
             ps.setInt(1, amount);
             ResultSet rs = ps.executeQuery();
             if (rs.next())
             {
                 int transactions = rs.getInt("amount");
                 int id = rs.getInt("id");
                 transaction = new Transaction(id, transactions, timestamp);
             } else
             {
                 throw new DatabaseException("Wrong email or password");
             }
         }
     } catch (SQLException ex)
     {
         throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
     }

     return transaction;
 }
 }


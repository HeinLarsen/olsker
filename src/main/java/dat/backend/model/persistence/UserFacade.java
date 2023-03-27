package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.awt.dnd.DropTarget;
import java.util.ArrayList;

public class UserFacade
{
    public static User login(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.login(email, password, connectionPool);
    }

    public static void createUser(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        UserMapper.createUser(email, password, connectionPool);
    }

    public static User updateBalance(int id, double amount, ConnectionPool connectionPool)throws DatabaseException
    {
         User u = UserMapper.updateBalance(id, amount, connectionPool);
         return u;



    }


    public static ArrayList<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.getAllUsers(connectionPool);

    }

    public static User getUserById(int id, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.getUserById(id, connectionPool);
    }

    public static void subtractBalance(User u, double getTotalPrice, ConnectionPool connectionPool) throws DatabaseException {
        UserMapper.subtractBalance(u, getTotalPrice, connectionPool);
    }
}

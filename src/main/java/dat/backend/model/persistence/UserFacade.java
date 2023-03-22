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

    public static User createUser(String email, String password, String role, int balance,  ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.createUser(email, password, role, balance, connectionPool);
    }

    public static User updateBalance(int id, int amount, ConnectionPool connectionPool)throws DatabaseException
    {
         return UserMapper.updateBalance(id, amount, connectionPool);
    }


    public static ArrayList<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.getAllUsers(connectionPool);
    }

    public static User getUserById(int id, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.getUserById(id, connectionPool);
    }
}

package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

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

    public static User updatebalance(int id, int amount, ConnectionPool connectionPool)throws DatabaseException
    {
         return UserMapper.updatebalance(id, amount, connectionPool);
    }





}

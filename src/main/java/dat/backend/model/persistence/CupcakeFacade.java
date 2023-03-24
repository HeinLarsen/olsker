package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class CupcakeFacade {


    public static ArrayList<Top> getTopById(ConnectionPool connectionPool) throws DatabaseException {
        return CupcakeMapper.getTopById(connectionPool);
    }

    public static ArrayList<Bottom> getBottomById(ConnectionPool connectionPool) throws DatabaseException {
        return CupcakeMapper.getBottomById(connectionPool);
    }
}

package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class CupcakeFacade {


    public static ArrayList<Top> getTopById(int topId, ConnectionPool connectionPool) throws DatabaseException {
        return CupcakeMapper.getTopById(topId, connectionPool);
    }

    public static ArrayList<Bottom> getBottomById(int bottomId, ConnectionPool connectionPool) throws DatabaseException {
        return CupcakeMapper.getBottomById(bottomId, connectionPool);
    }
}

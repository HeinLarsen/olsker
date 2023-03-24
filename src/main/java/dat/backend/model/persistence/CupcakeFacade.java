package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class CupcakeFacade {


    public static ArrayList<Top> getToppings(ConnectionPool connectionPool) throws DatabaseException {
        return CupcakeMapper.getToppings(connectionPool);
    }

    public static ArrayList<Bottom> getBottoms(ConnectionPool connectionPool) throws DatabaseException {
        return CupcakeMapper.getBottoms(connectionPool);
    }
}

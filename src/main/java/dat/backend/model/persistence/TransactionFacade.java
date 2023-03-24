package dat.backend.model.persistence;

import dat.backend.model.entities.Transaction;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Timestamp;

public class TransactionFacade
{
    public static Transaction transactionHistory(int amount, Timestamp timestamp, ConnectionPool connectionPool) throws DatabaseException
    {

        return TransactionMapper.getTransactionHistory(amount, timestamp, connectionPool);
    }
}

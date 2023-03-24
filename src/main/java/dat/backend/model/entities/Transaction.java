package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Transaction
{
    private int amount;
    private Timestamp timestamp;

    public Transaction(int id, int amount, Timestamp timestamp)
    {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Transaction(int amount)
    {
        this.amount = amount;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public int getAmount()
    {
        return amount;
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }
}

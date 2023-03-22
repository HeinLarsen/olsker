package dat.backend.model.entities;


import java.sql.Time;
import java.sql.Timestamp;

public class Transaction
{

    public int amount;
    private Timestamp date;

    public Transaction(int amount)
    {
       this.amount = amount;
       this.date =  new Timestamp(System.currentTimeMillis());;
    }

    public int getAmount()
    {
        return amount;
    }

    public Timestamp getDate()
    {
        return date;
    }







}



package dat.backend.model.entities;

import java.util.ArrayList;

public class Account
{
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account()
    {
        addAmount(0);
    }

    public void addAmount(int amount){
            transactions.add(new Transaction(amount));
    }


   public void subtractAmount(int amount )
   {
       transactions.add(new Transaction(-amount));
   }

   public int getbalance()
   {
       int sum = 0;
       for (Transaction transaction : transactions)
       {
           sum = sum + transaction.getAmount();
       }
        return sum;
   }

   public String getAccountList()
   {
       String result = "";
       for (Transaction transaction : transactions)
       {
           result = result + transaction.getDate() + ": " + transaction.getAmount() + " DKK\n";
       }
       return result;
   }

}





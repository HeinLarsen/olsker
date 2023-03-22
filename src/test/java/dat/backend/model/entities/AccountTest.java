package dat.backend.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest
{
    private Account account = new Account();

    @BeforeEach
    void setUp()
    {
        account.addAmount(100);
        account.addAmount(200);
        System.out.println(account.getAccountList());
    }

    @Test
    void addAmount()
    {
        int expected = 400;
        account.addAmount(100);
        int actual = account.getbalance();
        assertEquals(expected, actual);
    }

    @Test
    void subtractAmount()
    {
        int expected = 200;
        account.subtractAmount(100);
        int actual = account.getbalance();
        assertEquals(expected, actual);
    }

    @Test
    void getbalance()
    {
        int expected = 300;
        int actual = account.getbalance();
        assertEquals(expected, actual);
    }
}
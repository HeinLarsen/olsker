package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class User
{
    private int id;
    private String email;
    private String password;
    private int role;
    private int balance;

    public User(String email, String password, int role, int balance)
    {
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;

    }

    public User(int id, String email, String password, int role, int balance)
    {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;

    }



    public int getId() {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getRole()
    {
        return role;
    }

    public void setRole(int role)
    {
        this.role = role;
    }

    public int getBalance() {
        return balance;

    }




    @Override
    public int hashCode()
    {
        return Objects.hash(getEmail(), getPassword(), getRole());
    }

    @Override
    public String toString()
    {
        return "User{" +
                "brugerNavn='" + email + '\'' +
                ", kodeord='" + password + '\'' +
                ", rolle='" + role + '\'' +
                '}';
    }


}

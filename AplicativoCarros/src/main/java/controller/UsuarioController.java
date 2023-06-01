
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import beans.User;
import com.google.gson.Gson;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController{


    @Override
    public String login(String user, String password)
    {
        DBConnection connection = new DBConnection();
        String sql = "SELECT * FROM users WHERE username = '" + user + "' AND password = '" + password + "'";
        String result = "";
        try
        {
          
            Gson gson;
            gson = new Gson();
            Statement st = connection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
               
                int ID = rs.getInt("ID");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo"); 
                int premiun = rs.getInt("premiun");
                User userDTO = new User(ID, nombre, apellido1, apellido2,username, pass, email, saldo, premiun);
                result =  gson.toJson(userDTO);
            }
            return result;
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            connection.desconectar();
        }
    }
    
    @Override
    public String Create(String user, String password, String name, String email, String lastname1, String lastname2)
    {
        DBConnection connection = new DBConnection();
        String sql = "INSERT INTO users (nombre, apellido1, apellido2, username, password, email, saldo, premiun) \n" +
            "values (" + "'" + name + "'" + "," + "'" + lastname1 + "'" + "," + "'" + lastname2 + "'" + "," + "'" + user + "'" + "," + "'" + password + "'" + "," + "'" + email + "'" + ",0,0)" ;
        String result = "";
        
        try
        {
            Gson gson = new Gson();
            Statement st = connection.getConnection().createStatement();
            int rs = st.executeUpdate(sql);
            
            if(rs != 1)
            {
                throw new Exception("Errot to create the statement");
            }
            
            User userDTO = new User(0,name, lastname1, lastname2,user, password, email, 0, 0);
            result = gson.toJson(userDTO);
            return result;
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            connection.desconectar();
        }
    }
    
    @Override
    public String pedir(String user)
    {
        DBConnection connection = new DBConnection();
        Gson gson = new Gson();
        String sql = "SELECT * FROM users WHERE username = '" + user + "'";
        String result = "";
        try
        {
            Statement st = connection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
               
                int ID = rs.getInt("ID");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo"); 
                int premiun = rs.getInt("premiun");
                User userDTO = new User(ID, nombre, apellido1, apellido2,username, pass, email, saldo, premiun);
                result = gson.toJson(userDTO);
            }
            
            return result;
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
             connection.desconectar();
        }
    }
}

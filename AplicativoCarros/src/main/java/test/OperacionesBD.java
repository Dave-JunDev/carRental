
package test;

import beans.Carro;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
        listOfCars();
    }

    public static void updateCar(int id, String marca)
    {
        DBConnection connection = new DBConnection();

        String query = "UPDATE carros SET marca = '" + marca + "' WHERE id = " + id;

        try
        {
           Statement st = connection.getConnection().createStatement();
           st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println("Info to send in UPDATE id: " + id + " Marca: " + marca);
            System.out.println("Fatal error in UPDATE table carros: " + e.getMessage());
        }
        finally
        {
            connection.desconectar();
        }
    }

    public static void listOfCars()
    {
        DBConnection connection = new DBConnection();

        String query = "SELECT * FROM carros";

        try
        {
            Statement st = connection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                Carro car = new Carro(
                        rs.getInt("ID"),
                        rs.getString("marca"),
                        rs.getString("model"),
                        rs.getString("anio_lanzamiento"),
                        rs.getInt("novedad"),
                        rs.getString("price")
                    );

                System.out.println(car.toString());
            }
        }
        catch(Exception e)
        {
            System.out.println("Fatal error in list of cars: " + e.getMessage());
        }
        finally
        {
            connection.desconectar();
        }
    }
}

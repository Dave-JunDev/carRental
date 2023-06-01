package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import beans.Carro;
import connection.DBConnection;

public class CarrosController implements ICarrosController
{
    

    @Override
    public List<String> Listar(boolean ordernar, String orden)
    {
        Gson gson = new Gson();
        DBConnection dbConnection = new DBConnection();
        String sql = "SELECT * FROM carros";
        List<String> carros = new ArrayList<String>();
        try
        {
            if(ordernar)
            {
                sql += "order by model";
            }

            Statement st = dbConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                int Id = rs.getInt("ID");
                String marca = rs.getString("marca");
                String model = rs.getString("model");
                String anio = rs.getString("anio_lanzamiento");
                int novedad = rs.getInt("novedad");
                String price = rs.getString("price");

                Carro carro = new Carro(Id, marca, model, anio, novedad, price);
                carros.add(gson.toJson(carro));
            }

            return carros;
        }
        catch(Exception e)
        {
            e.getMessage();
            return null;
        }
        finally
        {
            dbConnection.desconectar();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.util.Date;

/**
 *
 * @author user
 */
public class Alquiler {

    private int id;
    private int username;
    private Date fecha;

    public Alquiler(int id, int username, Date fecha) {
        this.id = id;
        this.username = username;
        this.fecha = fecha;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setUsername(int username)
    {
        this.username = username;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public int getId()
    {
        return id;
    }

    public int getUsername()
    {
        return username;
    }

    public Date getFecha()
    {
        return fecha;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "id=" + id + ", username=" + username + ", fecha=" + fecha + '}';
    }

}

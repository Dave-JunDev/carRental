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
public class Carro {

    private int ID;
    private String marca;
    private String model;
    private String anio_lanzamiento;
    private int novedad;
    private String price;

    public Carro(int ID, String marca, String model, String anio_lanzamiento ,int novedad, String price) {
        this.ID = ID;
        this.marca = marca;
        this.model = model;
        this.novedad = novedad;
        this.anio_lanzamiento = anio_lanzamiento;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAnio_lanzamiento() {
        return anio_lanzamiento;
    }

    public void setAño_lanzamiento(String anio_lanzamiento) {
        this.anio_lanzamiento = anio_lanzamiento;
    }

    public int getNovedad() {
        return novedad;
    }

    public void setNovedad(int novedad) {
        this.novedad = novedad;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Carros{" + "ID=" + ID + ", marca=" + marca + ", model=" + model + ", a\u00f1o_lanzamiento=" + anio_lanzamiento + ", novedad=" + novedad + '}';
    }

}

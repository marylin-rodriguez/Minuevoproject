package org.marylin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Producto01")
public class Producto01 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private int ID;

    @Column(name = "Nombre")
    private int Nombre;

    @Column(name = "Descripcion")
    private String Descripcion;

    @Column(name = "Precio")
    private String precio;

    @Column(name = "Costo")
    private String Costo;

    @Column(name = "Stock")
    private  int Stock;

    public Producto01() {

    }
    public Producto01(int ID, int nombre, String descripcion, String precio, String costo, int stock) {
        this.ID = ID;
        Nombre = nombre;
        Descripcion = descripcion;
        this.precio = precio;
        Costo = costo;
        Stock = stock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNombre() {
        return Nombre;
    }

    public void setNombre(int nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String costo) {
        Costo = costo;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    @Override
    public String toString() {
        return "Producto01{" +
                "ID=" + ID +
                ", Nombre=" + Nombre +
                ", Descripcion='" + Descripcion + '\'' +
                ", precio='" + precio + '\'' +
                ", Costo='" + Costo + '\'' +
                ", Stock=" + Stock +
                '}';
    }
}

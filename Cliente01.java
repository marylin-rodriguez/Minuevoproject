package org.marylin.entity;

import jakarta.persistence.*;

@Entity
    @Table(name = "Cliente01")
    public class Cliente01 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column(name = "Fecha")
    private int Fecha;

    @Column(name = "Producto")
    private String Producto;

    @Column(name = "Cantidad")
    private String Cantidad;

    @Column(name = "Precio")
    private String Precio;

    @Column(name = "ID_Cliente")
    private  int ID_Cliente;

    @Column(name = "Nombre_Cliente")
    private String Nombre_Cliente;


    public Cliente01() {
    }
    public Cliente01( int Fecha, String Producto, String Cantidad, String Precio, int ID_Cliente, String Nombre_Cliente) {
        this.Fecha = Fecha;
        this.Producto = Producto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.ID_Cliente = ID_Cliente;
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getFecha() {
        return Fecha;
    }

    public void setFecha(int Fecha) {
        this.Fecha = Fecha;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = Cantidad;
    }
    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = Precio;
    }
    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(String id_Cliente) {
        ID_Cliente = ID_Cliente;
    }
    public int getNombre_Cliente() {
        return ID_Cliente;
    }

    public void setNombre_Cliente(String nombre_cliente) {
        Nombre_Cliente = Nombre_Cliente;
    }

    @Override
    public String toString() {
        return "Cliente01{" +
                "Fecha=" + Fecha +
                ", Producto='" + Producto + '\'' +
                ", Cantidad='" + Cantidad + '\'' +
                ", Precio='" + Precio + '\'' +
                ", ID_Cliente=" + ID_Cliente +
                ", Nombre_Cliente='" + Nombre_Cliente + '\'' +
                '}';
    }
}


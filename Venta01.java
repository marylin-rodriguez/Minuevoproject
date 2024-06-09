package org.marylin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Ventas")
public class Venta01{
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

    @Column(name = "Precio_Unitario")
    private String Precio_Unitario;

    @Column(name = "Id_Cliente")
    private  int Id_Cliente;

    @Column(name = "Nombre_Cliente")
    private String Nombre_Cliente;


    public Venta01(int id, int fecha, String producto, String cantidad, String precio_Unitario, int id_Cliente, String nombre_Cliente) {
        this.id = id;
        this.Fecha = fecha;
        this.Producto = producto;
        this.Cantidad = cantidad;
        this.Precio_Unitario = precio_Unitario;
        this.Id_Cliente = id_Cliente;
        this.Nombre_Cliente = nombre_Cliente;
    }

    public Venta01() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFecha() {
        return Fecha;
    }

    public void setFecha(int fecha) {
        Fecha = fecha;
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
        Cantidad = cantidad;
    }

    public String getPrecio_Unitario() {
        return Precio_Unitario;
    }

    public void setPrecio_Unitario(String precio_Unitario) {
        Precio_Unitario = precio_Unitario;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String nombre_Cliente) {
        Nombre_Cliente = nombre_Cliente;
    }

    @Override
    public String toString() {
        return "Venta01{" +
                "id=" + id +
                ", Fecha=" + Fecha +
                ", Producto='" + Producto + '\'' +
                ", Cantidad='" + Cantidad + '\'' +
                ", Precio_Unitario='" + Precio_Unitario + '\'' +
                ", Id_Cliente=" + Id_Cliente +
                ", Nombre_Cliente='" + Nombre_Cliente + '\'' +
                '}';
    }
}

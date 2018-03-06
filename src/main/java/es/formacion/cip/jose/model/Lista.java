package es.formacion.cip.jose.model;

import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "lista")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    @Column(name = "Producto")
    private String Producto;
    @Column(name = "Cantidad")
    private Double Cantidad;
    @Column(name = "Unidad")
    private String Unidad;

    public Lista(Integer ID, String producto, Double Cantidad, String unidad) {
        this.ID = ID;
        this.Producto = producto;
        this.Cantidad = Cantidad;
        this.Unidad = unidad;

    }

    public Lista() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Double cantidad) {
        Cantidad = cantidad;
    }

    public String getUnidad() {
        return Unidad;
    }

    public void setUnidad(String unidad) {
        Unidad = unidad;
    }

}
¡ERROR INTRODUCIDO!

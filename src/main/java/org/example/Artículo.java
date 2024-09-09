package org.example;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuperBuilder
@Entity
@Table
public class Artículo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "cantidad"
    )
    private int cantidad;
    @Column(
            name = "denominacion"
    )
    private String denominacion;
    @Column(
            name = "precio"
    )
    private int precio;


    @OneToMany(mappedBy = "artículo", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<DetalleFactura> detalles = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @Builder.Default
    private List<Categoría> categorías = new ArrayList<>();

    public Artículo(int cantidad, String denominacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
    }

    public Artículo(int cantidad, String denominacion, int precio, List<Categoría> categorías) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
        this.categorías = categorías;
    }

    public Artículo(int cantidad, String denominacion, int precio, List<DetalleFactura> facturas, List<Categoría> categorías) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
        this.detalles = detalles;
        this.categorías = categorías;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<Categoría> getCategorías() {
        return categorías;
    }

    public void setCategorías(List<Categoría> categorías) {
        this.categorías = categorías;
    }

   /* public List<DetalleFactura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<DetalleFactura> facturas) {
        this.facturas = facturas;
    }*/

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

}
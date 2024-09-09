package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder

@Entity
@Table
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private int subtotal;


    @ManyToOne(cascade = CascadeType.PERSIST) // Persist para evitar que se elimine el artículo al eliminar una factura
    @JoinColumn(name = "fk_articulo")
    private Artículo artículo;

    @ManyToOne
    @JoinColumn(name = "fk_factura") // Este debe coincidir con el nombre de la columna en Factura.
    private Factura factura; // Relación inversa que hace match con "mappedBy" en Factura.

    public DetalleFactura(int cantidad, int subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetalleFactura(int cantidad, int subtotal, Artículo artículo) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.artículo = artículo;
    }

    public DetalleFactura(int cantidad, int subtotal, Artículo artículo, Factura factura) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.artículo = artículo;
        this.factura = factura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public Artículo getArtículo() {
        return artículo;
    }

    public void setArtículo(Artículo artículo) {
        this.artículo = artículo;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void SetFactura(Factura factura1) {
    }
}
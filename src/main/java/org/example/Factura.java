package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder

@Entity
@Table
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "numero")
    private int numero;

    @Column(name = "total")
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST) // Persist para evitar que se elimine el cliente al eliminar una factura
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.PERSIST) // Relación con Factura sin eliminar cliente al eliminar factura.
    @JoinColumn(name = "fk_factura") // Clave foránea en DetalleFactura que apunta a Factura.
    private Factura factura;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true) // Configuración correcta de la relación OneToMany.
    @Builder.Default
    private List<DetalleFactura> detalles = new ArrayList<>(); // Usar un nombre representativo y correcto.

    public Factura(String fecha, int numero, int total) {
        this.fecha = fecha;
        this.numero = numero;
        this.total = total;
    }

    public Factura(String fecha, int numero, int total, Cliente cliente) {
        this.fecha = fecha;
        this.numero = numero;
        this.total = total;
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
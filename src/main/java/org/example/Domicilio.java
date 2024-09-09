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
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreCalle")
    private int nombreCalle;

    @Column(name = "numero")
    private String numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;



    public Domicilio(int nombreCalle, String numero) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
    }

    public Domicilio(int nombreCalle, String numero, Cliente cliente) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
        this.cliente = cliente;
    }

    public Domicilio(String sanJuan, int i) {
    }

    public int getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(int nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
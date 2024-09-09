//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuperBuilder
@Entity
@Table
public class Categoría implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "denominación"
    )
    private String denominacion;

    @ManyToMany(mappedBy = "categorías")
    @Builder.Default
    private List<Artículo> artículos = new ArrayList<>();

    public Categoría(String denominacion) {
        this.denominacion = denominacion;
    }

    public Categoría(String denominacion, List<Artículo> artículos) {
        this.denominacion = denominacion;
        this.artículos = artículos;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<Artículo> getArtículos() {
        return artículos;
    }

    public void setArtículos(List<Artículo> artículos) {
        this.artículos = artículos;
    }
}
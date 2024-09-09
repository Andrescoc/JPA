package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //System.out.println("en marcha Alberto");

        try {
            entityManager.getTransaction().begin();

            Factura factura1 = new Factura();
            factura1.setNumero(7);
            factura1.setFecha("25/07/2024");

            Domicilio domicilio = new Domicilio("Godoy Cruz", 942);
            Cliente cliente = new Cliente("Andres", "Juan", 4723485);
            cliente.setDomicilio(domicilio);
            domicilio.setCliente(cliente);

            factura1.setCliente(cliente);

            Categoría Deportes = new Categoría("Deportes");
            Categoría Alimentos = new Categoría("Alimentos");
            Categoría Electrodomésticos = new Categoría("Electrodomésticos");


            Artículo artículo1 = new Artículo(20, "lapiz", 100);
            Artículo artículo2 = new Artículo(10, "cartuchera", 800);

            artículo1.getCategorías().add(Deportes);
            artículo1.getCategorías().add(Alimentos);
            Alimentos.getArtículos().add(artículo1);
            Deportes.getArtículos().add(artículo1);

            artículo2.getCategorías().add(Electrodomésticos);
            Electrodomésticos.getArtículos().add(artículo2);


            DetalleFactura detalle1 = new DetalleFactura();
            detalle1.setArtículo(artículo1);
            detalle1.setCantidad(2);
            detalle1.setSubtotal(30);

            artículo1.getDetalles().add(detalle1);
            factura1.getDetalles().add(detalle1);
            detalle1.SetFactura(factura1);

            DetalleFactura detalle2 = new DetalleFactura();
            detalle2.setArtículo(artículo2);
            detalle2.setCantidad(2);
            detalle2.setSubtotal(40);

            artículo2.getDetalles().add(detalle2);
            factura1.getDetalles().add(detalle1);
            detalle2.SetFactura(factura1);

            factura1.setTotal(90);

            entityManager.persist(factura1);

            entityManager.flush();
            entityManager.getTransaction().commit();


        }catch (Exception e) {
            entityManager.getTransaction().rollback();

        }


        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
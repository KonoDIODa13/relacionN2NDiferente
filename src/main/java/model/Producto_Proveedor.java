package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "producto_proveedor")
public class Producto_Proveedor implements Serializable {
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "idproducto")
    private Productos producto;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "idproveedor")
    private Proveedores proveedor;

    @Column(name = "fechaEntrega")
    private LocalDate fechaEntrega;


    public Producto_Proveedor() {
    }

    public Producto_Proveedor(Productos producto, Proveedores proveedor, LocalDate fechaEntrega) {
        this.producto = producto;
        this.proveedor = proveedor;
        this.fechaEntrega = fechaEntrega;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        return "Producto_Proveedor{" +
                "producto=" + producto +
                ", proveedor=" + proveedor +
                ", fechaEntrega=" + fechaEntrega +
                '}';
    }
}

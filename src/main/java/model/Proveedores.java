package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "proveedores")
public class Proveedores {

    @Id
    @Column(name = "idproveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproveedor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nif")
    private String nif;

    @Column(name = "poblacion")
    private String poblacion;

    @OneToMany(mappedBy = "proveedor",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Producto_Proveedor> listaProducto_Provedor;

//constructores

    public Proveedores() {

    }

    public Proveedores(String nombre, String nif, String poblacion) {
        super();
        this.nombre = nombre;
        this.nif = nif;
        this.poblacion = poblacion;
    }
//metodos get y set

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public List<Producto_Proveedor> getListaProducto_Provedor() {
        return listaProducto_Provedor;
    }

    public void setListaProducto_Provedor(List<Producto_Proveedor> listaProducto_Provedor) {
        this.listaProducto_Provedor = listaProducto_Provedor;
    }

    @Override
    public String toString() {
        return "Proveedores [idproveedor=" + idproveedor + ", nombre=" + nombre + ", nif=" + nif + ", poblacion="
                + poblacion + "]";
    }

}

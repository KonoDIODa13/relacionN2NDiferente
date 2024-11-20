package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @Column(name = "idproducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "stock")
    private int stock;
    //ojo la siguiente defincion va toda junta
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategoria")
    private Categorias categoria;


    @OneToMany(mappedBy="producto",
            cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Producto_Proveedor> listaProducto_Provedor;

    //constructores
    public Productos() {

    }

    public Productos(String nombre, String descripcion, int stock) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    //metodos get y set

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Producto_Proveedor> getListaProducto_Provedor() {
        return listaProducto_Provedor;
    }

    public void setListaProducto_Provedor(List<Producto_Proveedor> listaProducto_Provedor) {
        this.listaProducto_Provedor = listaProducto_Provedor;
    }

    @Override
    public String toString() {
        return "Productos [idproducto=" + idproducto + ", nombre=" + nombre + ", descripcion=" + descripcion
                + ", stock=" + stock + ", categor�a=" + categoria + "]";
    }

}
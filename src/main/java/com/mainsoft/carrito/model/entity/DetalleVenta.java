package com.mainsoft.carrito.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "iddetalle_venta")
    private Integer iddetalleVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleVentaIddetalleVenta")
    private List<Venta> ventaList;
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto productoIdproducto;

    public Integer getIddetalleVenta() {
        return iddetalleVenta;
    }

    public void setIddetalleVenta(Integer iddetalleVenta) {
        this.iddetalleVenta = iddetalleVenta;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }
}

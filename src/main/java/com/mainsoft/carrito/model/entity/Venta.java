package com.mainsoft.carrito.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idventa")
    private Integer idventa;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JsonIgnoreProperties(value={"ventaList","hibernateLazyInitializer","handler"},allowSetters = true)
    @JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdcliente;
    @JoinColumn(name = "detalle_venta_iddetalle_venta", referencedColumnName = "iddetalle_venta",nullable = true)
    @ManyToOne()
    private DetalleVenta detalleVentaIddetalleVenta;

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(Cliente clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    public DetalleVenta getDetalleVentaIddetalleVenta() {
        return detalleVentaIddetalleVenta;
    }

    public void setDetalleVentaIddetalleVenta(DetalleVenta detalleVentaIddetalleVenta) {
        this.detalleVentaIddetalleVenta = detalleVentaIddetalleVenta;
    }
}

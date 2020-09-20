package com.mainsoft.carrito.model.service;

import com.mainsoft.carrito.model.entity.DetalleVenta;
import com.mainsoft.carrito.model.entity.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> findAll();

    public Venta findByIdVenta(Integer idVenta);

    public Venta save(Venta venta);

    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta);

}

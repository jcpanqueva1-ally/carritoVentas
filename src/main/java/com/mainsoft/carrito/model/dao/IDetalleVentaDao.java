package com.mainsoft.carrito.model.dao;

import com.mainsoft.carrito.model.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleVentaDao extends JpaRepository<DetalleVenta, Integer> {
}

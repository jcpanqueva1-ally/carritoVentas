package com.mainsoft.carrito.model.dao;

import com.mainsoft.carrito.model.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaDao extends JpaRepository<Venta, Integer> {
}

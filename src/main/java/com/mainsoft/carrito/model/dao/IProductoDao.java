package com.mainsoft.carrito.model.dao;

import com.mainsoft.carrito.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDao extends JpaRepository<Producto, Integer> {
}

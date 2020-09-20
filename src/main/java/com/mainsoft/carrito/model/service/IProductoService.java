package com.mainsoft.carrito.model.service;

import com.mainsoft.carrito.model.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> finaAll();

    public Producto findByIdProducto(Integer idProducto);

    public Producto save(Producto producto);

    public void deleteById(Integer idProducto);
}

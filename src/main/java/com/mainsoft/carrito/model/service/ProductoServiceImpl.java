package com.mainsoft.carrito.model.service;

import com.mainsoft.carrito.model.dao.IProductoDao;
import com.mainsoft.carrito.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoDao productoDao;

    @Override
    public List<Producto> finaAll() {
        return productoDao.findAll();
    }

    @Override
    public Producto findByIdProducto(Integer idProducto) {
        return productoDao.findById(idProducto).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public void deleteById(Integer idProducto) {
        productoDao.deleteById(idProducto);
    }
}

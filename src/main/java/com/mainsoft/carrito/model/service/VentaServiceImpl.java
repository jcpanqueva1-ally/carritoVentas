package com.mainsoft.carrito.model.service;

import com.mainsoft.carrito.model.dao.IDetalleVentaDao;
import com.mainsoft.carrito.model.dao.IVentaDao;
import com.mainsoft.carrito.model.entity.DetalleVenta;
import com.mainsoft.carrito.model.entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService{

    @Autowired
    private IVentaDao ventaDao;

    @Autowired
    private IDetalleVentaDao detalleVentaDao;

    @Override
    public List<Venta> findAll() {
        return ventaDao.findAll();
    }

    @Override
    public Venta findByIdVenta(Integer idVenta) {
        return ventaDao.findById(idVenta).orElse(null);
    }

    @Override
    public Venta save(Venta venta) {
        return ventaDao.save(venta);
    }

    @Override
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaDao.save(detalleVenta);
    }
}

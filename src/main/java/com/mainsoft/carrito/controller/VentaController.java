package com.mainsoft.carrito.controller;

import com.mainsoft.carrito.model.entity.DetalleVenta;
import com.mainsoft.carrito.model.entity.Producto;
import com.mainsoft.carrito.model.entity.Venta;
import com.mainsoft.carrito.model.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/CRV")
public class VentaController {

    @Autowired
    private IVentaService ventaService;


    @PostMapping("/ventas")
    public ResponseEntity<?> create(@RequestBody Venta venta) {
        Venta ventaNuevo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            DetalleVenta detalleVenta = venta.getDetalleVentaIddetalleVenta();
            DetalleVenta detalleVentaC = ventaService.saveDetalleVenta(detalleVenta);
            venta.setDetalleVentaIddetalleVenta(detalleVentaC);
            ventaNuevo = ventaService.save(venta);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al insertar en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente se ha creado con éxito");
        response.put("venta", ventaNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/ventas/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        Venta venta = null;
        Map<String, Object> response = new HashMap<>();

        try {
            venta = ventaService.findByIdVenta(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (venta == null) {
            response.put("mensaje",
                    "La venta con el ID: ".concat(id.toString().concat(" no existe en la basde de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Venta>(venta, HttpStatus.OK);
    }
}

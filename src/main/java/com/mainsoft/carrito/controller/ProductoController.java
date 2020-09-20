package com.mainsoft.carrito.controller;

import com.mainsoft.carrito.model.entity.Producto;
import com.mainsoft.carrito.model.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("CRV")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        Producto producto = null;
        Map<String, Object> response = new HashMap<>();

        try {
            producto = productoService.findByIdProducto(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (producto == null) {
            response.put("mensaje",
                    "El producto con el ID: ".concat(id.toString().concat(" no existe en la basde de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    @PostMapping("/productos")
    public ResponseEntity<?> create(@RequestBody Producto producto) {
        Producto productoNuevo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            productoNuevo = productoService.save(producto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al insertar en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente se ha creado con éxito");
        response.put("cliente", productoNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Integer id) {
        Producto productoActual = productoService.findByIdProducto(id);
        Producto productoUpdated = null;
        Map<String, Object> response = new HashMap<>();
        try {
            if (productoActual == null) {
                response.put("mensaje", "Error: no se pudo editar, el producto con el ID: "
                        .concat(id.toString().concat(" no existe en la basde de datos")));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

            }

            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());
            productoUpdated = productoService.save(productoActual);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el cliente en la base de datos ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El producto se ha actualizado con éxito");
        response.put("producto", productoUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Producto producto = productoService.findByIdProducto(id);
            productoService.deleteById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el cliente en la base de datos ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente se ha eliminado con éxito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}

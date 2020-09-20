package com.mainsoft.carrito.controller;

import com.mainsoft.carrito.model.entity.Cliente;
import com.mainsoft.carrito.model.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/CRV")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;


    @PostMapping("/clientes")
    public ResponseEntity<?> create(@RequestBody Cliente cliente) {
        Cliente clienteNuevo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            clienteNuevo = clienteService.save(cliente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al insertar en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente se ha creado con éxito");
        response.put("cliente", clienteNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


}

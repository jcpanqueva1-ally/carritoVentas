package com.mainsoft.carrito.model.service;

import com.mainsoft.carrito.model.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();

    public Cliente findByIdCliente(Integer idCLiente);

    public Cliente save(Cliente cliente);

    public void deleteByIdCliente(Integer idCliente);
}

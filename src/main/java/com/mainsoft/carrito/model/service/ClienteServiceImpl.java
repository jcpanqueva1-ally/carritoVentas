package com.mainsoft.carrito.model.service;

import com.mainsoft.carrito.model.dao.IClienteDao;
import com.mainsoft.carrito.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente findByIdCliente(Integer idCLiente) {
        return clienteDao.findById(idCLiente).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public void deleteByIdCliente(Integer idCliente) {
        clienteDao.deleteById(idCliente);
    }
}

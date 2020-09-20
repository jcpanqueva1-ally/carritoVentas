package com.mainsoft.carrito.model.dao;

import com.mainsoft.carrito.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente, Integer> {
}

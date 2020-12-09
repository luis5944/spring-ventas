package com.ventas.ventas.repository;

import com.ventas.ventas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio de datos para Cliente(Crud)
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}

package br.com.ada.test.cadastro.cliente.repository;

import br.com.ada.test.cadastro.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
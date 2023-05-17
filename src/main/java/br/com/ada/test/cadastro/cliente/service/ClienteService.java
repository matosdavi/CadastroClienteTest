package br.com.ada.test.cadastro.cliente.service;

import br.com.ada.test.cadastro.cliente.model.Cliente;
import br.com.ada.test.cadastro.cliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void excluir(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    public Cliente getById(long idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }
}
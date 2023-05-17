package br.com.ada.test.cadastro.cliente.controller;

import br.com.ada.test.cadastro.cliente.dto.request.ClienteSalvarRequestDTO;
import br.com.ada.test.cadastro.cliente.dto.response.ClienteSalvarResponseDTO;
import br.com.ada.test.cadastro.cliente.model.Cliente;
import br.com.ada.test.cadastro.cliente.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteSalvarResponseDTO salvar(@RequestBody ClienteSalvarRequestDTO requestDto) {

        Cliente cliente = new Cliente();
        cliente.setNome(requestDto.getNome());
        cliente.setEmail(requestDto.getEmail());

        cliente = clienteService.salvar(cliente);

        ClienteSalvarResponseDTO responseDto = new ClienteSalvarResponseDTO();
        responseDto.setId(cliente.getId());
        responseDto.setNome(cliente.getNome());
        responseDto.setEmail(cliente.getEmail());

        return responseDto;
    }
}
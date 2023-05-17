package br.com.ada.test.cadastro.cliente;

import br.com.ada.test.cadastro.cliente.model.Cliente;
import br.com.ada.test.cadastro.cliente.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	final ClienteService clienteService;

	ApplicationTests(@Autowired ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@Test
	@DisplayName("Test - Inserir Cliente - OK!")
	void inserir_cliente_ok() {

		Cliente cliente = new Cliente();
		cliente.setNome("Cliente test 2");
		cliente.setEmail("test@test.com");

		Cliente clienteSaved = clienteService.salvar(cliente);

		Assertions.assertNotNull(clienteSaved.getId());
		Assertions.assertEquals(cliente.getNome(), clienteSaved.getNome());
		Assertions.assertEquals(cliente.getEmail(), clienteSaved.getEmail());
	}

	@Test
	void excluir_cliente() {

		Cliente cliente = new Cliente();
		cliente.setNome("Cliente test");
		cliente.setEmail("test@test.com");

		Cliente clienteSaved = clienteService.salvar(cliente);

		Long idCliente = clienteSaved.getId();

		clienteService.excluir(idCliente);

		Cliente clienteDeleted = clienteService.getById(1L);

		Assertions.assertNull(clienteDeleted);
	}
}
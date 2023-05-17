package br.com.ada.test.cadastro.cliente.dto.response;

import lombok.Data;

@Data
public class ClienteSalvarResponseDTO {

    private Long id;
    private String nome;
    private String email;
}
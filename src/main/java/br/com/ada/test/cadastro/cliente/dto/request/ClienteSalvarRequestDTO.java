package br.com.ada.test.cadastro.cliente.dto.request;

import lombok.Data;

@Data
public class ClienteSalvarRequestDTO {

    private String nome;
    private String email;
}
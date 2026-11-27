package com.gabrielcastro.usuario.business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTO {

  private String logradouro;
  private String numero;
  private String complemento;
  private String cidade;
  private String estado;
  private String cep;
}

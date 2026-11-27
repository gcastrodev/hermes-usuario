package com.gabrielcastro.usuario.business.converter;

import com.gabrielcastro.usuario.business.dto.EnderecoDTO;
import com.gabrielcastro.usuario.business.dto.TelefoneDTO;
import com.gabrielcastro.usuario.business.dto.UsuarioDTO;
import com.gabrielcastro.usuario.infrastructure.entity.Endereco;
import com.gabrielcastro.usuario.infrastructure.entity.Telefone;
import com.gabrielcastro.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

  public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
    return Usuario.builder()
        .nome(usuarioDTO.getNome())
        .email(usuarioDTO.getEmail())
        .senha(usuarioDTO.getSenha())
        .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
        .telefones(paraListaTelefones(usuarioDTO.getTelefones()))
        .build();
  }

  public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTO) {
    return enderecoDTO.stream().map(this::paraEndereco).toList();
  }

  public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
    return Endereco.builder()
        .logradouro(enderecoDTO.getLogradouro())
        .numero(enderecoDTO.getNumero())
        .complemento(enderecoDTO.getComplemento())
        .cidade(enderecoDTO.getCidade())
        .estado(enderecoDTO.getEstado())
        .cep(enderecoDTO.getCep())
        .build();
  }

  public List<Telefone>  paraListaTelefones(List<TelefoneDTO> telefoneDTO) {
    return telefoneDTO.stream().map(this::paraTelefone).toList();
  }

  public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
    return Telefone.builder()
        .numero(telefoneDTO.getNumero())
        .ddd(telefoneDTO.getDdd())
        .build();
  }

  public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO) {
    return UsuarioDTO.builder()
        .nome(usuarioDTO.getNome())
        .email(usuarioDTO.getEmail())
        .senha(usuarioDTO.getSenha())
        .enderecos(paraListaEnderecoDTO(usuarioDTO.getEnderecos()))
        .telefones(paraListaTelefonesDTO(usuarioDTO.getTelefones()))
        .build();
  }

  public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTO) {
    return enderecoDTO.stream().map(this::paraEnderecoDTO).toList();
  }

  public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO) {
    return EnderecoDTO.builder()
        .logradouro(enderecoDTO.getLogradouro())
        .numero(enderecoDTO.getNumero())
        .complemento(enderecoDTO.getComplemento())
        .cidade(enderecoDTO.getCidade())
        .estado(enderecoDTO.getEstado())
        .cep(enderecoDTO.getCep())
        .build();
  }

  public List<TelefoneDTO>  paraListaTelefonesDTO(List<Telefone> telefoneDTO) {
    return telefoneDTO.stream().map(this::paraTelefoneDTO).toList();
  }

  public TelefoneDTO paraTelefoneDTO(Telefone telefoneDTO) {
    return TelefoneDTO.builder()
        .numero(telefoneDTO.getNumero())
        .ddd(telefoneDTO.getDdd())
        .build();
  }
}

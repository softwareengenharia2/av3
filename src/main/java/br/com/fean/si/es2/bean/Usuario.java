package br.com.fean.si.es2.bean;

import javax.persistence.*;

import br.com.fean.si.es2.dto.PrePedidoDTO;
import br.com.fean.si.es2.dto.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Usuario extends Bean {

	private String nome;

	private String documento;

	private String email;

	@OneToOne(fetch = FetchType.EAGER)
	private Endereco endereco;

	private String telefone;

	private TipoDeUsuario tipoDeUsuario;

	@OneToMany(mappedBy = "usuario", targetEntity = Pedido.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Pedido> pedidos;

	public Usuario(UsuarioDTO dto) {
		id = dto.getId();
		nome = dto.getNome();
		documento = dto.getDocumento();
		email = dto.getEmail();
		endereco = dto.getEnderecoBean();
		telefone = dto.getTelefone();
	}

	public Usuario (PrePedidoDTO dto) {
		documento = dto.getCnpj();
		email = dto.getEmail();
	}

	public Usuario() {

	}

	
}
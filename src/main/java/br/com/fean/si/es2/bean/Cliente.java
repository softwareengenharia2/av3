package br.com.fean.si.es2.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.fean.si.es2.dto.PreCadastroClienteDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;
	private String cnpj;
	private Double quantidade;
	private String email;

	public Cliente(PreCadastroClienteDTO dto) {
		id = dto.getId();
		cnpj = dto.getCnpj();
		quantidade = dto.getQuantidade();
		email = dto.getEmail();
	}

	public Cliente() {

	}

	
}
package br.com.fean.si.es2.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
//import br.com.fean.si.es2.annotation.NotNullAndNotEmpty;

@Getter
@Setter
public class PrePedidoDTO {

    //@NotNullAndNotEmpty(message = "Preencher campo CPF")
    private String cnpj;

    @Min(value = 8000, message = "Valor deve ser no mínimo 8000")
    private Double quantidade;

    @Pattern(regexp = "", message = "Email está inválido")
    private String email;

    private String mensagem;
}

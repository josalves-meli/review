package br.com.meli.review.dto;

import br.com.meli.review.entity.Vendedor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class VendedorDTO {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private char sexo;

    public Vendedor map() {
        return Vendedor.builder()
                .cpf(this.cpf)
                .nome(this.nome)
                .dataNascimento(this.dataNascimento)
                .sexo(this.sexo)
                .build();
    }

    public static VendedorDTO map(Vendedor vendedor) {
        return VendedorDTO.builder()
                .cpf(vendedor.getCpf())
                .nome(vendedor.getNome())
                .dataNascimento(vendedor.getDataNascimento())
                .sexo(vendedor.getSexo())
                .build();
    }
}

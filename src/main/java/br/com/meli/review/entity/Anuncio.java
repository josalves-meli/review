package br.com.meli.review.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // o id deve ser wrapper

    private String titulo;
    private BigDecimal preco;

    @ManyToOne
    private Vendedor vendedor;

}

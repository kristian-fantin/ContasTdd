package com.tdd.contas.domain.models;

import com.tdd.contas.domain.enums.TEspecialidade;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PRESTADOR")
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class Prestador {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PRESTADOR_ID")
    @SequenceGenerator(
            name = "SEQ_PRESTADOR_ID",
            allocationSize = 1,
            sequenceName = "SEQ_PRESTADOR_ID"
    )
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "ESPECIALIDADE")
    @Enumerated(EnumType.STRING)
    private TEspecialidade especialidade;

}

package com.tdd.contas.domain.models;

import com.tdd.contas.domain.enums.StatusPeg;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PEG")
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class Peg {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PEG_ID")
    @SequenceGenerator(
            name = "SEQ_PEG_ID",
            allocationSize = 1,
            sequenceName = "SEQ_PEG_ID"
    )
    private Long id;

    @Column(name = "DATA")
    private Date data;

    @Column(name = "NUMERO")
    private Long numero;

    @ManyToOne
    @JoinColumn(name = "PRESTADOR")
    private Prestador prestador;

    @Setter
    @Column(name = "OBSERVACAO")
    private String observacao;

    @Setter
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusPeg status;

}

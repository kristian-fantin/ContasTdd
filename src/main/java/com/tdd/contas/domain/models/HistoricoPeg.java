package com.tdd.contas.domain.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HISTORICO_PEG")
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class HistoricoPeg {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HISTPEG_ID")
    @SequenceGenerator(
            name = "SEQ_HISTPEG_ID",
            allocationSize = 1,
            sequenceName = "SEQ_HISTPEG_ID"
    )
    private Long id;

    @Column(name = "DATA")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "PEG")
    private Peg peg;

    @Column(name = "OBSERVACAO")
    private String observacao;

}

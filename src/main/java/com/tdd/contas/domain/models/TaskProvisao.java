package com.tdd.contas.domain.models;

import com.tdd.contas.domain.enums.StatusProvisao;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TASK_PROVISAO")
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class TaskProvisao {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROVISAO_ID")
    @SequenceGenerator(
            name = "SEQ_PROVISAO_ID",
            allocationSize = 1,
            sequenceName = "SEQ_PROVISAO_ID"
    )
    private Long id;

    @Column(name = "DATA")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "PEG")
    private Peg peg;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusProvisao status;

}

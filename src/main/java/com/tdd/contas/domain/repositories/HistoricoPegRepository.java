package com.tdd.contas.domain.repositories;

import com.tdd.contas.domain.models.HistoricoPeg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoPegRepository extends JpaRepository<HistoricoPeg, Long> {

}

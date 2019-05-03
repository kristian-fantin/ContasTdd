package com.tdd.contas.domain.repositories;

import com.tdd.contas.domain.models.Peg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PegRepository extends JpaRepository<Peg, Long> {

}

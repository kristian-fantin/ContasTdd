package com.tdd.contas.domain.repositories;

import com.tdd.contas.domain.models.TaskProvisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskProvisaoRepository extends JpaRepository<TaskProvisao, Long> {

}

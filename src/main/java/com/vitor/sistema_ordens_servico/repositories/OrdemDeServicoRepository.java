package com.vitor.sistema_ordens_servico.repositories;

import com.vitor.sistema_ordens_servico.domain.OrdemDeServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//jpaRepository, já implementa alguns métodos CRUD default para persistencia no banco

@Repository
public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Integer> {
}

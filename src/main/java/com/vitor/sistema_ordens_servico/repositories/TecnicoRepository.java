package com.vitor.sistema_ordens_servico.repositories;

import com.vitor.sistema_ordens_servico.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}

package com.alura.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import com.alura.modelo.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long>{

    Page<Topico> findAllByAutorActivoTrue(Pageable paginacion);
}

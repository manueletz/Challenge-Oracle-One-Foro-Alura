package com.alura.repository;

import com.alura.modelo.Topico;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long>{
    List<Topico> findAll();
}

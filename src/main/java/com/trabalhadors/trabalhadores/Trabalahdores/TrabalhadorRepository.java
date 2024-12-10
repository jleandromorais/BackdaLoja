package com.trabalhadors.trabalhadores.Trabalahdores;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;

public interface TrabalhadorRepository  extends JpaRepository<Trabalhador,Long> {
    List<Trabalhador> findByAtivoTrue();
}

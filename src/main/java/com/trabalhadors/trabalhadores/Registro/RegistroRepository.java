package com.trabalhadors.trabalhadores.Registro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RegistroRepository extends JpaRepository<Registro,Long> {
    List<Registro> findByAtivoTrue();
    boolean existsByEmail(String email);
    Registro findByEmail(String email);
}

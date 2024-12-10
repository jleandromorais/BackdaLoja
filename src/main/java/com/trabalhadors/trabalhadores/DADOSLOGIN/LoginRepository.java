package com.trabalhadors.trabalhadores.DADOSLOGIN;

import com.trabalhadors.trabalhadores.Trabalahdores.Trabalhador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {
    List<Login> findByAtivoTrue();
    Login findByEmail(String email);
}

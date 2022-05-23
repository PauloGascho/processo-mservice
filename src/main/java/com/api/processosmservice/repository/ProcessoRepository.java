package com.api.processosmservice.repository;

import com.api.processosmservice.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Integer> {

    @Query("SELECT p.numero FROM Processo p")
    List<Integer> findNumeros();
}

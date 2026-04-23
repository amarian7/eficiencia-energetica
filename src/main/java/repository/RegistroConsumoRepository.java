package com.fiap.eficiencia.energetica.repository;

import com.fiap.eficiencia.energetica.model.RegistroConsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroConsumoRepository extends JpaRepository<RegistroConsumo, Long> {
    // Métodos CRUD básicos herdados.
}
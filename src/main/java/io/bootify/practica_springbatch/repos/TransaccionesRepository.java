package io.bootify.practica_springbatch.repos;

import io.bootify.practica_springbatch.domain.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {
}

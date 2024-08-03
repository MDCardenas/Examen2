package hn.unah.examenlenguajes.examen.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.examenlenguajes.examen.modelos.Prestamos;

public interface PrestamosRepositorios extends JpaRepository<Prestamos, Long> {
    
}

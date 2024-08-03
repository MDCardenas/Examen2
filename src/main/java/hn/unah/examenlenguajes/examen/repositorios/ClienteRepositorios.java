package hn.unah.examenlenguajes.examen.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.examenlenguajes.examen.modelos.Cliente;

public interface ClienteRepositorios extends JpaRepository<Cliente, String> {
    
}

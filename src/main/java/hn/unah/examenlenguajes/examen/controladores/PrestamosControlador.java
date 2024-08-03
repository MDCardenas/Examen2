package hn.unah.examenlenguajes.examen.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.examenlenguajes.examen.modelos.Prestamos;
import hn.unah.examenlenguajes.examen.servicios.PrestamosServicios;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/prestamos")
public class PrestamosControlador {

    @Autowired
    private PrestamosServicios prestamosServicios;

    @PostMapping("/crear/nuevo")
    public Prestamos crearPrestamo(@RequestBody Prestamos nvPrestamos, @PathVariable(name="dni") String dni) {
        return this.prestamosServicios.crearPrestamo(dni, nvPrestamos);
    }

    @GetMapping("/buscar/{codigoprestamo}")
    public Prestamos buscarCodigoPrestamo(@PathVariable(name="codigoprestamo") long codigoprestamo) {
        return this.prestamosServicios.buscarPorCodigoPrestamo(codigoprestamo);
    }
    
    
}

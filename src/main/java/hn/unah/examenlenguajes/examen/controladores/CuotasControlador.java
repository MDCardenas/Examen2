package hn.unah.examenlenguajes.examen.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.examenlenguajes.examen.servicios.CuotasServicios;

@RestController
@RequestMapping("/api/cuotas")
public class CuotasControlador {
    
    @Autowired
    private CuotasServicios cuotasServicios;
    

}

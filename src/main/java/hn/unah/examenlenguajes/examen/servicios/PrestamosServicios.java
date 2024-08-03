package hn.unah.examenlenguajes.examen.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.examenlenguajes.examen.modelos.Prestamos;
import hn.unah.examenlenguajes.examen.repositorios.ClienteRepositorios;
import hn.unah.examenlenguajes.examen.repositorios.PrestamosRepositorios;

@Service
public class PrestamosServicios {
    
    @Autowired
    private PrestamosRepositorios prestamosRepositorios;

    @Autowired
    private ClienteRepositorios clienteRepositorios;

    public Prestamos crearPrestamo(String dni, Prestamos nvoPrestamos){
        if(this.clienteRepositorios.existsById(dni)){
            nvoPrestamos.setCliente(this.clienteRepositorios.findById(dni).get());
             double cuota = ((nvoPrestamos.getMonto()*(0.09/12))/(1-Math.pow(1 + (0.09/12), nvoPrestamos.getPlazo()*12)));
            nvoPrestamos.setCuota(cuota);
            return this.prestamosRepositorios.save(nvoPrestamos);
        }

        return null;
    }

    public Prestamos buscarPorCodigoPrestamo(long codigoprestamo){
        if(this.prestamosRepositorios.existsById(codigoprestamo)){
            return this.prestamosRepositorios.getReferenceById(codigoprestamo);
        }
        return null;
    }
}

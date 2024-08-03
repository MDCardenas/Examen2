package hn.unah.examenlenguajes.examen.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.examenlenguajes.examen.modelos.Cliente;
import hn.unah.examenlenguajes.examen.modelos.Prestamos;
import hn.unah.examenlenguajes.examen.repositorios.ClienteRepositorios;

@Service
public class ClienteServicios {
    
    @Autowired
    private ClienteRepositorios clienteRepositorios;

    public Cliente crearNuevoCliente(Cliente nvoCliente){
        if(this.clienteRepositorios.existsById(nvoCliente.getDni())){
            return null;
        }

        List<Prestamos> prestamos = nvoCliente.getPrestamos();
        if(prestamos!=null){
            for(Prestamos prestamo : prestamos){
                prestamo.setCliente(nvoCliente);
            }
        }


        return this.clienteRepositorios.save(nvoCliente);
    }

    public List<Cliente> obtenerTodos(){
        return this.clienteRepositorios.findAll();
    }

    public boolean buscarPorIdentidad(String identidad){
        return this.clienteRepositorios.existsById(identidad);
    }

}

package hn.unah.examenlenguajes.examen.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.examenlenguajes.examen.modelos.Cliente;
import hn.unah.examenlenguajes.examen.servicios.ClienteServicios;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/cliente")
public class ClienteControlador {
    
    @Autowired
    private ClienteServicios clienteServicios;

    @PostMapping("/crear/nuevo")
    public Cliente creaCliente(@RequestBody Cliente nvoCliente){
        if(!this.clienteServicios.buscarPorIdentidad(nvoCliente.getDni())){
            return this.clienteServicios.crearNuevoCliente(nvoCliente);
        }
        return null;
    }

    @GetMapping("/obtener/todos")
    public List<Cliente> obtenerMaestros() {
        return this.clienteServicios.obtenerTodos();
    }
    

}

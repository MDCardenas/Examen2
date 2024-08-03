package hn.unah.examenlenguajes.examen.modelos;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="prestamos")
@Data
public class Prestamos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigoprestamo")
    private long codigoPrestamo;

    private Date fechaApertura;

    private double monto;

    private double cuota;

    private int plazo;

    private double interes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codigocliente", referencedColumnName = "codigocliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "codigocuota", cascade = CascadeType.ALL)
    private List<Cuotas> cuotas;
}

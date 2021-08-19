package com.dan.dot.pagos.domain;

import com.dan.dot.pagos.dto.Cliente;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @JsonBackReference
    private Cliente cliente;
    private Date fecha;
    private Double monto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    private FormaPago forma;

    private Boolean habilitado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() { return monto; }

    public void setMonto(Double monto) { this.monto = monto; }

    public FormaPago getForma() {
        return forma;
    }

    public void setForma(FormaPago forma) {
        this.forma = forma;
    }

    public Boolean getHabilitado() { return habilitado; }

    public void setHabilitado(Boolean habilitado) { this.habilitado = habilitado; }

}

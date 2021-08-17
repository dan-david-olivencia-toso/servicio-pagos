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
    //TODO: Agregar de nuevo las propiedades faltantes
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    private FormaPago forma;
//    private Pedido pedido;

//    public Pedido getPedido() {
//        return pedido;
//    }
//
//    public void setPedido(Pedido pedido) {
//        this.pedido = pedido;
//    }

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

    public FormaPago getForma() {
        return forma;
    }

    public void setForma(FormaPago forma) {
        this.forma = forma;
    }
}

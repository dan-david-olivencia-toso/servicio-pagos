package com.dan.dot.pagos.domain;

import java.time.Instant;

public class Pago {
    private Integer id;
    private Cliente cliente;
    private Instant fecha;
    private FormaPago forma;
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

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

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public FormaPago getForma() {
        return forma;
    }

    public void setForma(FormaPago forma) {
        this.forma = forma;
    }
}

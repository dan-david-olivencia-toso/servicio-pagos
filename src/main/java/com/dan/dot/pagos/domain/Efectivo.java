package com.dan.dot.pagos.domain;

public class Efectivo extends FormaPago {
    public Integer getNroRecibo() {
        return nroRecibo;
    }

    public void setNroRecibo(Integer nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    private Integer nroRecibo;
}

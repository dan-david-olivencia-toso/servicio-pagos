package com.dan.dot.pagos.domain;

import java.time.Instant;

public class Cheque extends FormaPago {
    private Integer numero;
    private Instant fechaCobro; //TODO: Fecha nula al crear -> Cheque corriente. Fecha futura -> Cheque diferido
    private String banco;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Instant getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Instant fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}

package com.dan.dot.pagos.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "cheque")
public class Cheque extends FormaPago {

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    @Column(name = "fecha_cobro", nullable = true)
    private Instant fechaCobro; //TODO: Fecha nula al crear -> Cheque corriente. Fecha futura -> Cheque diferido
    private String banco;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append("Id Cheque: ").append(this.id).append("\n");
        sb.append("Número: ").append(this.numero).append("\n");
        sb.append("Fecha de Cobro: ").append(this.fechaCobro).append("\n");
        sb.append("Banco: ").append(this.banco).append("\n");

        return sb.toString();
    }

}

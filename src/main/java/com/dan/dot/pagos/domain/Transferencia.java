package com.dan.dot.pagos.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "transferencia")
public class Transferencia extends FormaPago {

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
    public String getCbuOrigen() { return cbuOrigen; }
    public void setCbuOrigen(String cbuOrigen) { this.cbuOrigen = cbuOrigen; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cbu_origen")
    private String cbuOrigen;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append("Id Transferencia: ").append(this.id).append("\n");
        sb.append("CBU Origen: ").append(this.cbuOrigen).append("\n");

        return sb.toString();
    }

}

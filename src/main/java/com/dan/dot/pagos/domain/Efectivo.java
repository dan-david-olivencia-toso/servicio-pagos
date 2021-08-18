package com.dan.dot.pagos.domain;

import javax.persistence.*;

@Entity
@Table(name = "efectivo")
public class Efectivo extends FormaPago {

    public Integer getNumeroRecibo() { return numeroRecibo; }
    public void setNumeroRecibo(Integer nroRecibo) { this.numeroRecibo = nroRecibo; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_recibo")
    private Integer numeroRecibo;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append("Id Efectivo: ").append(this.id).append("\n");
        sb.append("Número de Recibo: ").append(this.numeroRecibo).append("\n");

        return sb.toString();
    }

}

package com.dan.dot.pagos.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_pago")
public class FormaPago {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Id
    private Integer id;
    private String detalle;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Id: ").append(this.id).append("\n");
        sb.append("Detalle: ").append(this.detalle).append("\n");

        return sb.toString();
    }
}

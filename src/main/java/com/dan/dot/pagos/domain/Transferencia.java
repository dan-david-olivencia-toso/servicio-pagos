package com.dan.dot.pagos.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "transferencia")
public class Transferencia extends FormaPago {

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Long getCodigoTransferencia() { return codigoTransferencia; }
    public void setCodigoTransferencia(Long codigoTransferencia) { this.codigoTransferencia = codigoTransferencia; }
    public String getCbuOrigen() { return cbuOrigen; }
    public void setCbuOrigen(String cbuOrigen) { this.cbuOrigen = cbuOrigen; }
    public String getCbuDestino() { return cbuDestino; }
    public void setCbuDestino(String cbuDestino) { this.cbuDestino = cbuDestino; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cbu_origen")
    private String cbuOrigen;
    @Column(name = "cbu_destino")
    private String cbuDestino;
    @Column(name = "codigo_transferencia")
    private Long codigoTransferencia;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append("Id Transferencia: ").append(this.id).append("\n");
        sb.append("CBU Origen: ").append(this.cbuOrigen).append("\n");
        sb.append("CBU Destino: ").append(this.cbuDestino).append("\n");
        sb.append("Código de Transferencia: ").append(this.codigoTransferencia).append("\n");

        return sb.toString();
    }

}

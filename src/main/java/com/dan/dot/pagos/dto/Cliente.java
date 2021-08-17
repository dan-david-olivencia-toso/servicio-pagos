package com.dan.dot.pagos.dto;

import com.dan.dot.pagos.domain.Pago;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Double getMaxCuentaCorriente() {
        return maxCuentaCorriente;
    }

    public void setMaxCuentaCorriente(Double maxCuentaCorriente) {
        this.maxCuentaCorriente = maxCuentaCorriente;
    }

    public Boolean getHabilitadoOnline() {
        return habilitadoOnline;
    }

    public void setHabilitadoOnline(Boolean habilitadoOnline) {
        this.habilitadoOnline = habilitadoOnline;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "razon_social")
    private String razonSocial;
    private String cuit;
    private String mail;
    @Column(name = "max_cuenta_corriente")
    private Double maxCuentaCorriente;
    @Column(name = "habilitado_online")
    private Boolean habilitadoOnline;

    @Column(name = "fecha_baja")
    private Date fechaBaja;

    @OneToMany(mappedBy = "cliente")
    private List<Pago> pagos;

}

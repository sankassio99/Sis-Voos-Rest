/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kassi
 */
@Entity
public class Reservas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nomeCliente ;
    @Temporal(TemporalType.DATE)
    private java.util.Date data ;
    
    @ManyToOne
    private Voos voo ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }


    public Voos getVoo() {
        return voo;
    }

    public void setVoo(Voos voo) {
        this.voo = voo;
    }
    
    
}

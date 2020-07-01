/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kassi
 */
public class Voos {
    private int id ;
    private Cidade origem ;
    private Cidade destino;
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }
    
    
}

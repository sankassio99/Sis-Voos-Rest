/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import com.google.gson.Gson;
import dao.VoosDAO;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Voos;

/**
 *
 * @author kassi
 */
@Path("/voos")
public class VoosResource {
    Voos voo = new Voos();
    
    //BUSCA PELA ORIGEM E DESTINO
    @GET
    @Path("{origemDestino}")//Palmas-SaoPaulo
    @Produces(MediaType.APPLICATION_JSON)
    public String getVoo(@PathParam("origemDestino")String origemDestino){
        Gson gson = new Gson();
        String[] words = origemDestino.split("-");
        //separa a origem do destino para fazer a busca no banco de dados 
        VoosDAO dao = new VoosDAO();
        return gson.toJson(dao.findByTrajeto(words[0], words[1]));
    }
    
    @GET
    @Path("{origemDestino}/{dataPartida}")//Palmas-SaoPaulo
    @Produces(MediaType.APPLICATION_JSON)
    public String getVoo1(@PathParam("origemDestino")String origemDestino,@PathParam("dataPartida")String dataPartida){
        Gson gson = new Gson();
        String[] words = origemDestino.split("-");
        //separa a origem do destino para fazer a busca no banco de dados 
        VoosDAO dao = new VoosDAO();
        List<Voos> voos = dao.findByTrajetoData(words[0], words[1],dataPartida);
        
        return gson.toJson(voos);
    }
    
    @GET
    @Path("{origemDestino}/{dataPartida}/{faixaPreco}")//Palmas-SaoPaulo
    @Produces(MediaType.APPLICATION_JSON)
    public String getVoo2(@PathParam("origemDestino")String origemDestino,@PathParam("dataPartida")String dataPartida,@PathParam("faixaPreco")String faixaPreco){
        Gson gson = new Gson();
        String[] words = origemDestino.split("-");
        String[] preco = faixaPreco.split("-");
        double precoMin = Double.parseDouble(preco[0]);
        double precoMax = Double.parseDouble(preco[1]);
        //separa a origem do destino para fazer a busca no banco de dados 
        VoosDAO dao = new VoosDAO();
        List<Voos> voos = dao.findByTrajetoDataPreco(words[0], words[1],dataPartida,precoMin,precoMax);
        
        return gson.toJson(voos);
    }

    
    //BUSCA PELO ID. APENAS PARA TESTE
//    @GET
//    @Path("{id}")//1
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getVoo(@PathParam("id")int id){
//        Gson gson = new Gson();
//        
//        VoosDAO dao =new VoosDAO();
//        voo = dao.findById(id);
//        
//        return gson.toJson(voo);
//    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import com.google.gson.Gson;
import dao.ReservasDAO;
import dao.VoosDAO;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Reservas;
import model.Voos;

/**
 *
 * @author kassio
 */
@Path("/voos")
public class VoosResource {
    Voos voo = new Voos();
    VoosDAO dao = new VoosDAO();
    ReservasDAO rDao = new ReservasDAO();
    
    //BUSCA PELA ORIGEM E DESTINO
    @GET
    @Path("{origem}/{destino}")// 977/3035
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Voos> getVoo(@PathParam("origem")String origem, @PathParam("destino")String destino){
        
        return dao.findByTrajeto(origem, destino);
        
    }
    
    //ORIGEM, DESTINO E DATA DE PARTIDA
    @GET
    @Path("{origem}/{destino}/{dataPartida}")//Palmas-SaoPaulo
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Voos> getVoo1(@PathParam("origem")String origem, @PathParam("destino")String destino,
            @PathParam("dataPartida")String dataPartida){ 
        
        return dao.findByTrajetoData(origem, destino,dataPartida);
            
    }
    
    //ORIGEM, DESTINO, DATA DE PARTIDA E FAIXA DE PREÇO
    @GET
    @Path("{origem}/{destino}/{dataPartida}/{precoMin}/{precoMax}")//Palmas-SaoPaulo
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Voos> getVoo2(@PathParam("origem")String origem, @PathParam("destino")String destino,
            @PathParam("dataPartida")String dataPartida,@PathParam("precoMin")double precoMin,@PathParam("precoMax")double precoMax){
        
        return dao.findByTrajetoDataPreco(origem, destino,dataPartida,precoMin,precoMax);
    };
    
    //RESERVAR VOO 
    @POST
    @Path("/reserva")
    @Consumes(MediaType.APPLICATION_JSON)
    public int reserve(Reservas reserva){
        return rDao.save(reserva);
    };
    
    
    //Buscar reserva pelo ID
    @GET
    @Path("reserva/{id}")//
    @Produces(MediaType.APPLICATION_JSON)
    public Reservas getReserve(@PathParam("id")Integer id){
        
        return rDao.findById(id);
    };
    
    //Alterar reserva do Voo
    @PUT
    @Path("/reserva")
    @Consumes(MediaType.APPLICATION_JSON)
    public int reserveUpdate(Reservas reserva){
        return rDao.save(reserva);
    };
    
    //Deletando reserva do Voo
    @DELETE
    @Path("/reserva/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Reservas reserveDelete(@PathParam("id")Integer id ){
        return rDao.remove(id);
    };
    
    
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

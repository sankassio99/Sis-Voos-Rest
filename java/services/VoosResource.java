/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import dao.VoosDAO;
import java.util.ArrayList;
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
    
    @GET
    @Path("{origemDestino}")//Palmas-SaoPaulo
    @Produces(MediaType.APPLICATION_JSON)
    public String getVoo(@PathParam("origemDestino")String origemDestino){
        Gson gson = new Gson();
        String[] words = origemDestino.split("-");
        //separa a origem do destino para fazer a busca no banco de dados 
        
        VoosDAO dao = new VoosDAO();
        voo = dao.buscaVoo(words[0], words[1]);
        
        return gson.toJson(voo);
    }

}

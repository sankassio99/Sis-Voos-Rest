/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import model.Cidade;
import model.Voos;

/**
 *
 * @author kassi
 */
public class VoosDAO {
    
    
    public Voos findById(int id){
        EntityManager em = new ConnectionFactory().getConnection();
        Voos voo = null ;
        try{
            voo = em.find(Voos.class, id);
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return voo ;
    }
    public ArrayList<Voos> findByTrajeto(String origem, String destino){
        EntityManager em = new ConnectionFactory().getConnection();
        ArrayList <Voos> voos = null ;
        System.out.println("Origem: "+origem+" detino: "+destino);
        try{
            voos = (ArrayList<Voos>) em.createQuery("from Voos where destino_id="+destino+" and origem_id="+origem).getResultList();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return voos ;  
    }
    public ArrayList<Voos> findByTrajetoData(String origem, String destino, String data){
        EntityManager em = new ConnectionFactory().getConnection();
        ArrayList <Voos> voos = null ;
        System.out.println("Origem: "+origem+" detino: "+destino+" data: "+data);
        try{
            voos = (ArrayList<Voos>) em.createQuery("from Voos where destino_id="+destino+" and origem_id="+origem+" and data_partida='"+data+"'").getResultList();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return voos ;  
    }
    
    public ArrayList<Voos> findByTrajetoDataPreco(String origem, String destino, String data, double min, double max){
        EntityManager em = new ConnectionFactory().getConnection();
        ArrayList <Voos> voos = null ;
        System.out.println("Origem: "+origem+" detino: "+destino+" data: "+data+" precoMin: "+min+ "PrecoMax: "+max);
        try{
            voos = (ArrayList<Voos>) em.createQuery("from Voos where destino_id="+destino+
                    " and origem_id="+origem+" and data_partida='"+data+"' and preco BETWEEN "+min+" and "+max).getResultList();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return voos ;  
    }
    

}

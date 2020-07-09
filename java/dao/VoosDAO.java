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
//        CidadeDAO cDAO = new CidadeDAO();;
//        int idOrigem = cDAO.findByName(origem);
//        int idDestino = cDAO.findByName(destino);
//        System.out.println("Dados buscado da tabela cidade: ");
        try{
            voos = (ArrayList<Voos>) em.createQuery("from Voos where destino_id="+destino+" and origem_id="+origem).getResultList();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return voos ;  
    }
    
    
    
//    public Voos buscaVoo(String origem, String destino){;
//        
//        Voos voo = new Voos();
//        CidadeDAO cDAO = new CidadeDAO() ;
//        try{
//            PreparedStatement ps = connection.prepareStatement("select * from voos where origem=? and destino=?");
//            ps.setString(1, origem);
//            ps.setString(2, destino);
//            ResultSet rs =  ps.executeQuery() ;
//            while(rs.next()){
//                voo.setId(rs.getInt("id"));
//                voo.setOrigem(cDAO.buscaCidade(rs.getString("origem")));
//                voo.setDestino(cDAO.buscaCidade(rs.getString("destino")));
//            }    
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        return voo ;
//    }
    
//    public Voos save(Voos origem, Voos destino){
//        
//        EntityManager em = new ConnectionFactory().getConnection();
//        
//        try{
//            
//            em.createQuery("from Produto c where origem="+origem+" and destino="+destino).getResultList();
//            
//        }catch(Exception e){
//            em.getTransaction().rollback();
//            System.err.println(e);
//        }finally{
//            em.close();
//        }
//     
//        return produto ;
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import model.Cidade;
import model.Voos;

/**
 *
 * @author kassi
 */
public class VoosDAO {
    private Connection connection;

    public VoosDAO() {
        connection = ConnectionFactory.getConnection();
    }
    
    public Voos buscaVoo(String origem, String destino){;
        
        Voos voo = new Voos();
        CidadeDAO cDAO = new CidadeDAO() ;
        Cidade cidade = new Cidade();
        try{
            PreparedStatement ps = connection.prepareStatement("select * from voos where origem=? and destino=?");
            ps.setString(1, origem);
            ps.setString(2, destino);
            ResultSet rs =  ps.executeQuery() ;
            while(rs.next()){
                voo.setId(rs.getInt("id"));
                voo.setOrigem(cDAO.buscaCidade(rs.getString("origem")));
                voo.setDestino(cDAO.buscaCidade(rs.getString("destino")));
            }    
        }catch(SQLException e){
            e.printStackTrace();
        }
        return voo ;
    }
    
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

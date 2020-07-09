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
public class CidadeDAO {
//     private Connection connection;
//
//    public CidadeDAO() {
//        connection = ConnectionFactory.getConnection();
//    }
//    
//    public Cidade buscaCidade(String nome){;
//        
//        Cidade cidade = new Cidade() ;
//        try{
//            PreparedStatement ps = connection.prepareStatement("select * from cidade where nome=? ");
//            ps.setString(1, nome);
//            ResultSet rs =  ps.executeQuery() ;
//            while(rs.next()){
//                cidade.setId(rs.getInt("id"));
//                cidade.setNome(rs.getString("nome"));
//                cidade.setEstado(rs.getInt("estado_id"));
//            }    
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        return cidade ;
//    }
    
    public Cidade findById(int id){
        EntityManager em = new ConnectionFactory().getConnection();
        Cidade cidade = null ;
        try{
            cidade = em.find(Cidade.class, id);
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return cidade ;
    }
    public int findByName(String nome){
        EntityManager em = new ConnectionFactory().getConnection();
        Cidade cidade = null ;
        int id = 0 ;
        try{
//            cidade = em.createQuery("from Cidade where nome="+nome).getResultList();;
            id = cidade.getId();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return id ;
    }
}

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
import model.Cidade;
import model.Voos;

/**
 *
 * @author kassi
 */
public class CidadeDAO {
     private Connection connection;

    public CidadeDAO() {
        connection = ConnectionFactory.getConnection();
    }
    
    public Cidade buscaCidade(String nome){;
        
        Cidade cidade = new Cidade() ;
        try{
            PreparedStatement ps = connection.prepareStatement("select * from cidade where nome=? ");
            ps.setString(1, nome);
            ResultSet rs =  ps.executeQuery() ;
            while(rs.next()){
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                cidade.setEstado(rs.getInt("estado_id"));
            }    
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cidade ;
    }
}

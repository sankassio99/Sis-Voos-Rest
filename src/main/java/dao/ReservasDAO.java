/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import javax.persistence.EntityManager;
import model.Reservas;

/**
 *
 * @author kassi
 */
public class ReservasDAO {
    public int save(Reservas reserva){
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try{
            
            em.getTransaction().begin();
            if(reserva.getId()==null){
                em.persist(reserva);
            }else {
                em.merge(reserva);
            }
            em.getTransaction().commit();
            
        }catch(Exception e){
            em.getTransaction().rollback();
            System.err.println(e);
        }finally{
            em.close();
        }
     
        return reserva.getId() ;
    }
    
    public Reservas remove(int id){
        EntityManager em = new ConnectionFactory().getConnection();
        Reservas r = null ;
        
        try{
            r = em.find(Reservas.class, id);
            
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
            
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        return r ;       
    }
    
    public Reservas findById(int id){
        EntityManager em = new ConnectionFactory().getConnection();
        Reservas cidade = null ;
        try{
            cidade = em.find(Reservas.class, id);
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return cidade ;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techtitans.service;

import com.techtitans.model.MetodoDePago;
import com.techtitans.util.Jpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Donovan Morales
 */
public class MetodoDePagoService implements InterfaceMetodoDePagoService{
    
    private EntityManager em; 
    
    public MetodoDePagoService(){
        this.em = Jpa.getEntityManager();
    }
   

    @Override
    public void agregarMetodoDePago(MetodoDePago metodo) {
      EntityTransaction transction = em.getTransaction();
        try{
            transction.begin();
            em.persist(metodo);
            transction.commit();
        }catch(Exception e){
            if(transction.isActive()){
            transction.rollback();
            }
        e.printStackTrace();
        }
        
    }

    @Override
    public List<MetodoDePago> listaMetodoDePago() {
        TypedQuery<MetodoDePago> query = em.createQuery("select m from MetodoDePago m", MetodoDePago.class);
        return query.getResultList();
    }
    
}

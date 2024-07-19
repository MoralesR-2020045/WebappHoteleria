package com.techtitans.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Jpa {

    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
      try{
          return Persistence.createEntityManagerFactory("DBHoteleria");
      }catch(Throwable e){
            throw new ExceptionInInitializerError(e);
      }
    }
    
    public static EntityManager getEntityManager(){
      return emf.createEntityManager();
     }
    
    public static void close(){
         emf.close();
     }
    
    
    
}

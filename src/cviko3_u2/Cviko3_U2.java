/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko3_u2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eduardo Martinez
 */
public class Cviko3_U2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("p1");
        EntityManager em = emf.createEntityManager();
        
        Cviko3_U2 obj = new Cviko3_U2();
        
        //obj.persist(em);
        //obj.persistMerge(em);
        //obj.clear(em);
        //obj.detach(em);
        obj.findfind(em);
        
    }
    
    void persist(EntityManager em){
        Osoba osoba1 = new Osoba("Juro");
        Osoba osoba2 = new Osoba("Juro");

        Osoba[] osoby = { osoba1,osoba2 };
        
        for (int i = 0;i < osoby.length;i++){
             em.getTransaction().begin();
             em.persist(osoby[i]);
             em.getTransaction().commit();
        }
    }
    
    void persistMerge(EntityManager em){
        //GeneratedValue zakomentovane
        Osoba osoba1 = new Osoba(Long.valueOf(10),"Juro",80.0);
        Osoba osoba2 = new Osoba(Long.valueOf(10),"Petr",82.0);

        em.getTransaction().begin();
        em.persist(osoba1);
        em.merge(osoba2);
        em.getTransaction().commit();
    }
    
    void clear(EntityManager em){
        //GeneratedValue zakomentovane
        Osoba osoba1 = new Osoba(Long.valueOf(10),"Juro");
        Osoba osoba2 = new Osoba(Long.valueOf(10),"Jaroslav");

        em.getTransaction().begin();
        em.persist(osoba1);
        em.clear();
        em.persist(osoba2);
        em.getTransaction().commit();
    }
    
    void detach(EntityManager em){
        //GeneratedValue zakomentovane
        Osoba osoba1 = new Osoba(Long.valueOf(10),"Juro");
        Osoba osoba2 = new Osoba(Long.valueOf(10),"Jaroslav");

        em.getTransaction().begin();
        em.persist(osoba1);
        em.persist(osoba2);
        em.detach(osoba2);
        em.getTransaction().commit();
    }
    
    void findfind(EntityManager em){
        //GeneratedValue zakomentovane
        Osoba osoba1 = (Osoba) em.find(Osoba.class, Long.valueOf(10));
        osoba1 = (Osoba) em.find(Osoba.class, Long.valueOf(10));

        if (osoba1 == null){
            
        }
    }
}

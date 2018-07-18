package org.tss.engim.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.tss.engim.PM;
import org.tss.engim.db.ChiavePrimaria;

public class DAOGenerico
{
  public static void inserisci_o_aggiorna(ChiavePrimaria p)
  {
    EntityManager em = PM.db(); // connect db
    EntityTransaction et = em.getTransaction(); // BEGIN transaction
    try
    {
      et.begin();
      if (p.getId() == null)
      {
        em.persist(p); // insert
      }
      else
      {
        p = em.find(p.getClass(), p.getId()); // ricarica l'oggetto
        em.merge(p); // update
      }
      et.commit();
    }
    finally
    {
      if (et.isActive()) 
        et.rollback();
      em.close();
    }
  }
  
  public static void elimina(ChiavePrimaria p)
  {
    EntityManager em = PM.db();
    EntityTransaction et = em.getTransaction(); 
    try
    {
      p = em.find(p.getClass(), p.getId());
      et.begin(); 
      em.remove(p);
      et.commit(); 
    }
    finally
    {
      if (et.isActive()) 
        et.rollback();
      em.close();
    }
  }
}

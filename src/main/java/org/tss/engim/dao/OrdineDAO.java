package org.tss.engim.dao;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.wicket.markup.html.basic.Label;
import org.tss.engim.PM;
import org.tss.engim.db.TariffaCorriere;
import org.tss.engim.db.Articolo;
import org.tss.engim.db.Voce;
import org.tss.engim.db.Ordine;

public class OrdineDAO
{
  //private static DecimalFormat df2 = new DecimalFormat("#####.##");
    
  public static float pesoTotale(Ordine o)
  {
    EntityManager db = PM.db();
    
    try
    
    {
      Ordine o_reloaded = db.find(Ordine.class, o.getId());
            
      Collection<Voce> voci = o_reloaded.getVoceCollection();
      float pesotot = 0;
      for (Voce v: voci)
      {
        pesotot = pesotot + v.getQuantita() * v.getIdArticolo().getPeso().floatValue();
      }
      return pesotot;

    } 
    
    finally 
    
    {
      db.close();
    }
  }
  
  public static TariffaCorriere costoBasso(Ordine o)
  {
    double pesoOrdine = pesoTotale(o);
    
    EntityManager db = PM.db();
    
    try
    {
      TypedQuery<TariffaCorriere> selectAll = 
              db.createNamedQuery("TariffaCorriere.findAll", TariffaCorriere.class);
      
      
      List<TariffaCorriere> results = selectAll.getResultList();
      TariffaCorriere minimo = null;
      for (TariffaCorriere tc: results)
      {
        if (tc.getPesoMassimo().floatValue() >= pesoOrdine) 
        {
  
          if (minimo == null)
          minimo = tc;
          else
          {
          
            if (tc.getCosto().floatValue() < minimo.getCosto().floatValue())
              minimo = tc;
          }
        }
        
      }
      
      return minimo;
      //return df2.format(minimo);

    }
    
    finally
    {
      db.close();
    }
  }
  
}
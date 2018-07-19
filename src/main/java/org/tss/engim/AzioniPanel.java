package org.tss.engim;

import javax.persistence.PersistenceException;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.tss.engim.dao.DAOGenerico;
import org.tss.engim.db.ChiavePrimaria;


public class AzioniPanel extends Panel
{
  
  public AzioniPanel(String id, final ChiavePrimaria p)
  {
    super(id);
    
    add(new AjaxLink("elimina")
    {
      @Override
      public void onClick(AjaxRequestTarget art)
      {
        try
        {
          DAOGenerico.elimina(p);
        }
        // lanciamo un messaggio di errore nel feedbackpanel se tentiamo di eleiminare qualcosa che avevamo inserito dal db
        catch(PersistenceException pe)
        {
          getPage().error("Ci sono delle relazioni, non puoi eliminare l'elemento!");
        }        
        throw new RestartResponseException(getPage());
      }   
    });

  }
  
}

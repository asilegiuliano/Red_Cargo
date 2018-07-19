package org.tss.engim;

import java.math.BigDecimal;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.RangeValidator;
import org.tss.engim.db.TariffaCorriere;
import org.tss.engim.dao.DAOGenerico;


public class FormEditTariffaCorriere extends Form<TariffaCorriere>
{
  private TariffaCorriere tc;

  public FormEditTariffaCorriere(String id)
  {
    super(id);
    add(new FeedbackPanel("feedback"));
    //c = new CostoMezzoTrasporto();
    
    setDefaultModel(new CompoundPropertyModel<TariffaCorriere>(tc));
    
    // add(new TextField("id"));
    
    // NOME CORRIERE
    TextField nomeCorriere = new TextField("nomeCorriere");
    nomeCorriere.setRequired(true);
    add(nomeCorriere);
    
    // NOME TARIFFA
    TextField nomeTariffa = new TextField("nomeTariffa");
    nomeTariffa.setRequired(true);
    add(nomeTariffa);
    
    // PESO MASSIMO
    NumberTextField pesoMassimo = new NumberTextField("pesoMassimo");
    pesoMassimo.setStep(0.1);
    pesoMassimo.setRequired(true);
    pesoMassimo.add(new RangeValidator<>(BigDecimal.valueOf(0.1), BigDecimal.valueOf(100000)));
    add(pesoMassimo);
    
    // COSTO
    NumberTextField costo = new NumberTextField("costo");
    costo.setStep(0.1);
    costo.setRequired(true);
    costo.add(new RangeValidator<>(BigDecimal.valueOf(0.1), BigDecimal.valueOf(1000000)));
    add(costo);
  }

  @Override
  protected void onBeforeRender()
  {
    tc = new TariffaCorriere();
    setDefaultModel(new CompoundPropertyModel<TariffaCorriere>(tc));
    super.onBeforeRender(); 
  }
  
  

  @Override
  protected void onSubmit()
  {
      DAOGenerico.inserisci_o_aggiorna(tc);
      tc.setId(null);
  }
   
}

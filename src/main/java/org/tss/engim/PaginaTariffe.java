package org.tss.engim;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.tss.engim.db.Ordine;
import org.tss.engim.db.TariffaCorriere;

public class PaginaTariffe extends PaginaBase
{
  public PaginaTariffe()
  {
    List <IColumn <TariffaCorriere, String>> tariffa = new LinkedList <>();
    
    PropertyColumn <TariffaCorriere, String> id = new PropertyColumn<>(Model.of("Id"), "id");
    PropertyColumn <TariffaCorriere, String> nome_corriere = new PropertyColumn<>(Model.of("Nome Corriere"), "nomeCorriere");
    PropertyColumn <TariffaCorriere, String> nome_tariffa = new PropertyColumn<>(Model.of("Nome Tariffa"), "nomeTariffa");
    PropertyColumn <TariffaCorriere, String> peso_massimo = new PropertyColumn<>(Model.of("Peso Massimo"), "pesoMassimo");
    PropertyColumn <TariffaCorriere, String> costo = new PropertyColumn<>(Model.of("Costo"), "costo");
    
    tariffa.add(id);
    tariffa.add(nome_corriere);
    tariffa.add(nome_tariffa);
    tariffa.add(peso_massimo);
    tariffa.add(costo);
    
    SPDataProvider<TariffaCorriere> dataprov = new SPDataProvider<>(TariffaCorriere.class);
    
    DefaultDataTable table = new DefaultDataTable ("tariffe", tariffa, dataprov, 10);
    
    add(table);
    
  }
}

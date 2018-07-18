package org.tss.engim;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.tss.engim.dao.OrdineDAO;
import org.tss.engim.db.Ordine;
import org.tss.engim.db.TariffaCorriere;

public class PaginaOrdini extends PaginaBase
{
  public PaginaOrdini()
  {
    List <IColumn <Ordine, String>> ordine = new LinkedList <>();
    
    PropertyColumn <Ordine, String> id = new PropertyColumn<>(Model.of("Id"), "id");
    PropertyColumn <Ordine, String> numero = new PropertyColumn<>(Model.of("Numero Ordine"), "numero");
    PropertyColumn <Ordine, String> data = new PropertyColumn<>(Model.of("Data Ordine"), "data");
    
    // ABSTRACT COLUMN PESO TOTALE
    
    AbstractColumn <Ordine, String> pesoTot = new AbstractColumn <Ordine, String>(Model.of("Peso Totale"))
    {
      @Override
      public void populateItem(Item<ICellPopulator<Ordine>> item, String wicketid, IModel<Ordine> rowmodel)
      {
        String pesoTot = String.valueOf(OrdineDAO.pesoTotale(rowmodel.getObject()));
        Label cf = new Label (wicketid, "" + pesoTot);
        item.add(cf);
      }
    };
    
    // ABSTRACT COLUMN COSTO TOTALE
    
    AbstractColumn <Ordine, String> tariffaCorriere = new AbstractColumn <Ordine, String>(Model.of("Mezzo"))
    {
      @Override
      public void populateItem(Item<ICellPopulator<Ordine>> item, String wicketid, IModel<Ordine> rowmodel)
      {
        TariffaCorriere tc = OrdineDAO.costoBasso(rowmodel.getObject());
        String mezzo = "€" + tc.getCosto() + " (" + tc.getNomeCorriere() + ' ' + tc.getNomeTariffa() + ")";
        Label cf = new Label (wicketid, "" + mezzo);
        item.add(cf);
      }
    };
    
    ordine.add(id);
    ordine.add(numero);
    ordine.add(data);
    ordine.add(pesoTot);
    ordine.add(tariffaCorriere);
    
    SPDataProvider<Ordine> dataprov = new SPDataProvider<>(Ordine.class);
    
    DefaultDataTable table = new DefaultDataTable ("ordini", ordine, dataprov, 10);
    
    add(table);
  }
}

package org.tss.engim;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.tss.engim.db.Articolo;

public class PaginaArticoli extends PaginaBase
{
  public PaginaArticoli()
  {
    List <IColumn <Articolo, String>> articolo = new LinkedList <>();
    
    PropertyColumn <Articolo, String> id = new PropertyColumn<>(Model.of("Id"), "id");
    PropertyColumn <Articolo, String> codice = new PropertyColumn<>(Model.of("Codice"), "codice");
    PropertyColumn <Articolo, String> descrizione = new PropertyColumn<>(Model.of("Descrizione"), "descrizione");
    PropertyColumn <Articolo, String> peso = new PropertyColumn<>(Model.of("Peso"), "peso");
    
    articolo.add(id);
    articolo.add(codice);
    articolo.add(descrizione);
    articolo.add(peso);
    
    SPDataProvider<Articolo> dataprov = new SPDataProvider<>(Articolo.class);
    
    DefaultDataTable table = new DefaultDataTable ("articoli", articolo, dataprov, 10);
    
    add(table);
  }
}

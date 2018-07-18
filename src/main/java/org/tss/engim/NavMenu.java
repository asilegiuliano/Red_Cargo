package org.tss.engim;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class NavMenu extends Panel
{
  public NavMenu(String id)
  {
    super(id);
    
    BookmarkablePageLink home = 
      new BookmarkablePageLink("home", 
        HomePage.class);
    add(home);
    
    BookmarkablePageLink articoli = 
      new BookmarkablePageLink("articoli", 
        PaginaArticoli.class);
    add(articoli);
    
    BookmarkablePageLink tariffe = 
      new BookmarkablePageLink("tariffe", 
        PaginaTariffe.class);
    add(tariffe);
    
    BookmarkablePageLink ordini = 
      new BookmarkablePageLink("ordini", 
        PaginaOrdini.class);
    add(ordini);
    
   
    
    
  }
  
}

/*
 * Copyright 2018 svilupposw.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tss.engim.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author svilupposw
 */
@Entity
@Table(name = "voce")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Voce.findAll", query = "SELECT v FROM Voce v")
  , @NamedQuery(name = "Voce.findById", query = "SELECT v FROM Voce v WHERE v.id = :id")
  , @NamedQuery(name = "Voce.findByQuantita", query = "SELECT v FROM Voce v WHERE v.quantita = :quantita")
})
public class Voce implements Serializable, ChiavePrimaria
{

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "quantita")
  private int quantita;
  @JoinColumn(name = "id_articolo", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Articolo idArticolo;
  @JoinColumn(name = "id_ordine", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Ordine idOrdine;

  public Voce()
  {
  }

  public Voce(Integer id)
  {
    this.id = id;
  }

  public Voce(Integer id, int quantita)
  {
    this.id = id;
    this.quantita = quantita;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public int getQuantita()
  {
    return quantita;
  }

  public void setQuantita(int quantita)
  {
    this.quantita = quantita;
  }

  public Articolo getIdArticolo()
  {
    return idArticolo;
  }

  public void setIdArticolo(Articolo idArticolo)
  {
    this.idArticolo = idArticolo;
  }

  public Ordine getIdOrdine()
  {
    return idOrdine;
  }

  public void setIdOrdine(Ordine idOrdine)
  {
    this.idOrdine = idOrdine;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Voce))
    {
      return false;
    }
    Voce other = (Voce) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "org.tss.engim.db.Voce[ id=" + id + " ]";
  }
  
}

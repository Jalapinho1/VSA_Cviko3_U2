/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko3_u2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eduardo Martinez
 */
@Entity
@Table(name = "OSOBA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Osoba.findAll", query = "SELECT o FROM Osoba o"),
    @NamedQuery(name = "Osoba.findById", query = "SELECT o FROM Osoba o WHERE o.id = :id"),
    @NamedQuery(name = "Osoba.findByMeno", query = "SELECT o FROM Osoba o WHERE o.meno = :meno"),
    @NamedQuery(name = "Osoba.findByNarodena", query = "SELECT o FROM Osoba o WHERE o.narodena = :narodena"),
    @NamedQuery(name = "Osoba.findByVaha", query = "SELECT o FROM Osoba o WHERE o.vaha = :vaha")})
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "MENO")
    private String meno;
    @Column(name = "NARODENA")
    @Temporal(TemporalType.DATE)
    private Date narodena;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VAHA")
    private Double vaha;

    public Osoba() {
    }

    public Osoba(Long id) {
        this.id = id;
    }

    public Osoba(String meno) {
        this.meno = meno;
    }

    public Osoba(Long id, String meno) {
        this.id = id;
        this.meno = meno;
    }

    public Osoba(Long id, String meno, Double vaha) {
        this.id = id;
        this.meno = meno;
        this.vaha = vaha;
    }

    public Osoba(String meno, Date narodena, Double vaha) {
        this.meno = meno;
        this.narodena = narodena;
        this.vaha = vaha;
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public Date getNarodena() {
        return narodena;
    }

    public void setNarodena(Date narodena) {
        this.narodena = narodena;
    }

    public Double getVaha() {
        return vaha;
    }

    public void setVaha(Double vaha) {
        this.vaha = vaha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osoba)) {
            return false;
        }
        Osoba other = (Osoba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cviko3_u2.Osoba[ id=" + id + " ]";
    }
    
}

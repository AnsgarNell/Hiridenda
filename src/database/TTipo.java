/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author InAns
 */
@Entity
@Table(name = "T_TIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTipo.findAll", query = "SELECT t FROM TTipo t"),
    @NamedQuery(name = "TTipo.findByTipId", query = "SELECT t FROM TTipo t WHERE t.tipId = :tipId"),
    @NamedQuery(name = "TTipo.findByTipNombre", query = "SELECT t FROM TTipo t WHERE t.tipNombre = :tipNombre"),
    @NamedQuery(name = "TTipo.findByTipDescrip", query = "SELECT t FROM TTipo t WHERE t.tipDescrip = :tipDescrip")})
public class TTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TIP_ID")
    private BigDecimal tipId;
    @Basic(optional = false)
    @Column(name = "TIP_NOMBRE")
    private String tipNombre;
    @Column(name = "TIP_DESCRIP")
    private String tipDescrip;

    public TTipo() {
    }

    public TTipo(BigDecimal tipId) {
        this.tipId = tipId;
    }

    public TTipo(BigDecimal tipId, String tipNombre) {
        this.tipId = tipId;
        this.tipNombre = tipNombre;
    }

    public BigDecimal getTipId() {
        return tipId;
    }

    public void setTipId(BigDecimal tipId) {
        this.tipId = tipId;
    }

    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }

    public String getTipDescrip() {
        return tipDescrip;
    }

    public void setTipDescrip(String tipDescrip) {
        this.tipDescrip = tipDescrip;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipId != null ? tipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTipo)) {
            return false;
        }
        TTipo other = (TTipo) object;
        if ((this.tipId == null && other.tipId != null) || (this.tipId != null && !this.tipId.equals(other.tipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TTipo[ tipId=" + tipId + " ]";
    }
    
}

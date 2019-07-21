/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author InAns
 */
@Entity
@Table(name = "T_LOCALIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLocalizacion.findAll", query = "SELECT t FROM TLocalizacion t"),
    @NamedQuery(name = "TLocalizacion.findByLocId", query = "SELECT t FROM TLocalizacion t WHERE t.locId = :locId"),
    @NamedQuery(name = "TLocalizacion.findByLocNombre", query = "SELECT t FROM TLocalizacion t WHERE t.locNombre = :locNombre"),
    @NamedQuery(name = "TLocalizacion.findByLocDescrip", query = "SELECT t FROM TLocalizacion t WHERE t.locDescrip = :locDescrip"),
    @NamedQuery(name = "TLocalizacion.findByLocEstado", query = "SELECT t FROM TLocalizacion t WHERE t.locEstado = :locEstado"),
    @NamedQuery(name = "TLocalizacion.findByLocDateEnd", query = "SELECT t FROM TLocalizacion t WHERE t.locDateEnd = :locDateEnd"),
    @NamedQuery(name = "TLocalizacion.findByLocX", query = "SELECT t FROM TLocalizacion t WHERE t.locX = :locX"),
    @NamedQuery(name = "TLocalizacion.findByLocY", query = "SELECT t FROM TLocalizacion t WHERE t.locY = :locY")})
public class TLocalizacion implements Serializable {
    @Column(name =     "LOC_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date locDateEnd;
    
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "LOC_ID")
    private BigDecimal locId;
    @Basic(optional = false)
    @Column(name = "LOC_NOMBRE")
    private String locNombre;
    @Column(name = "LOC_DESCRIP")
    private String locDescrip;
    @Basic(optional = false)
    @Column(name = "LOC_ESTADO")
    private BigInteger locEstado;
    @Column(name = "LOC_X")
    private String locX;
    @Column(name = "LOC_Y")
    private String locY;    

    public TLocalizacion() {
    }

    public TLocalizacion(BigDecimal locId) {
        this.locId = locId;
    }

    public TLocalizacion(BigDecimal locId, String locNombre, BigInteger locEstado) {
        this.locId = locId;
        this.locNombre = locNombre;
        this.locEstado = locEstado;
    }

    public BigDecimal getLocId() {
        return locId;
    }

    public void setLocId(BigDecimal locId) {
        this.locId = locId;
    }

    public String getLocNombre() {
        return locNombre;
    }

    public void setLocNombre(String locNombre) {
        this.locNombre = locNombre;
    }

    public String getLocDescrip() {
        return locDescrip;
    }

    public void setLocDescrip(String locDescrip) {
        this.locDescrip = locDescrip;
    }

    public BigInteger getLocEstado() {
        return locEstado;
    }

    public void setLocEstado(BigInteger locEstado) {
        this.locEstado = locEstado;
    }

    public Date getLocDateEnd() {
        return locDateEnd;
    }

    public void setLocDateEnd(Date locDateEnd) {
        this.locDateEnd = locDateEnd;
    }

    public String getLocX() {
        return locX;
    }

    public void setLocX(String locX) {
        this.locX = locX;
    }

    public String getLocY() {
        return locY;
    }

    public void setLocY(String locY) {
        this.locY = locY;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locId != null ? locId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLocalizacion)) {
            return false;
        }
        TLocalizacion other = (TLocalizacion) object;
        if ((this.locId == null && other.locId != null) || (this.locId != null && !this.locId.equals(other.locId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLocalizacion[ locId=" + locId + " ]";
    }


    
}

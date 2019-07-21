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
@Table(name = "T_MAGNITUD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMagnitud.findAll", query = "SELECT t FROM TMagnitud t"),
    @NamedQuery(name = "TMagnitud.findByMagId", query = "SELECT t FROM TMagnitud t WHERE t.magId = :magId"),
    @NamedQuery(name = "TMagnitud.findByMagNombre", query = "SELECT t FROM TMagnitud t WHERE t.magNombre = :magNombre"),
    @NamedQuery(name = "TMagnitud.findByMagDescrip", query = "SELECT t FROM TMagnitud t WHERE t.magDescrip = :magDescrip"),
    @NamedQuery(name = "TMagnitud.findByMagEstado", query = "SELECT t FROM TMagnitud t WHERE t.magEstado = :magEstado"),
    @NamedQuery(name = "TMagnitud.findByMagDateEnd", query = "SELECT t FROM TMagnitud t WHERE t.magDateEnd = :magDateEnd")})
public class TMagnitud implements Serializable {
    @Column(name = "MAG_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date magDateEnd;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MAG_ID")
    private BigDecimal magId;
    @Basic(optional = false)
    @Column(name = "MAG_NOMBRE")
    private String magNombre;
    @Column(name = "MAG_DESCRIP")
    private String magDescrip;
    @Basic(optional = false)
    @Column(name = "MAG_ESTADO")
    private BigInteger magEstado;

    public TMagnitud() {
    }

    public TMagnitud(BigDecimal magId) {
        this.magId = magId;
    }

    public TMagnitud(BigDecimal magId, String magNombre, BigInteger magEstado) {
        this.magId = magId;
        this.magNombre = magNombre;
        this.magEstado = magEstado;
    }

    public BigDecimal getMagId() {
        return magId;
    }

    public void setMagId(BigDecimal magId) {
        this.magId = magId;
    }

    public String getMagNombre() {
        return magNombre;
    }

    public void setMagNombre(String magNombre) {
        this.magNombre = magNombre;
    }

    public String getMagDescrip() {
        return magDescrip;
    }

    public void setMagDescrip(String magDescrip) {
        this.magDescrip = magDescrip;
    }

    public BigInteger getMagEstado() {
        return magEstado;
    }

    public void setMagEstado(BigInteger magEstado) {
        this.magEstado = magEstado;
    }

    public Date getMagDateEnd() {
        return magDateEnd;
    }

    public void setMagDateEnd(Date magDateEnd) {
        this.magDateEnd = magDateEnd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (magId != null ? magId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMagnitud)) {
            return false;
        }
        TMagnitud other = (TMagnitud) object;
        if ((this.magId == null && other.magId != null) || (this.magId != null && !this.magId.equals(other.magId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TMagnitud[ magId=" + magId + " ]";
    } 
}

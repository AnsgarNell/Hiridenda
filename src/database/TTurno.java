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
@Table(name = "T_TURNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTurno.findAll", query = "SELECT t FROM TTurno t"),
    @NamedQuery(name = "TTurno.findByTurId", query = "SELECT t FROM TTurno t WHERE t.turId = :turId"),
    @NamedQuery(name = "TTurno.findByTurNombre", query = "SELECT t FROM TTurno t WHERE t.turNombre = :turNombre"),
    @NamedQuery(name = "TTurno.findByTurDescrip", query = "SELECT t FROM TTurno t WHERE t.turDescrip = :turDescrip"),
    @NamedQuery(name = "TTurno.findByTurEstado", query = "SELECT t FROM TTurno t WHERE t.turEstado = :turEstado"),
    @NamedQuery(name = "TTurno.findByTurDateEnd", query = "SELECT t FROM TTurno t WHERE t.turDateEnd = :turDateEnd")})
public class TTurno implements Serializable {
    @Column(name =     "TUR_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date turDateEnd;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TUR_ID")
    private BigDecimal turId;
    @Basic(optional = false)
    @Column(name = "TUR_NOMBRE")
    private String turNombre;
    @Column(name = "TUR_DESCRIP")
    private String turDescrip;
    @Basic(optional = false)
    @Column(name = "TUR_ESTADO")
    private BigInteger turEstado;

    public TTurno() {
    }

    public TTurno(BigDecimal turId) {
        this.turId = turId;
    }

    public TTurno(BigDecimal turId, String turNombre, BigInteger turEstado) {
        this.turId = turId;
        this.turNombre = turNombre;
        this.turEstado = turEstado;
    }

    public BigDecimal getTurId() {
        return turId;
    }

    public void setTurId(BigDecimal turId) {
        this.turId = turId;
    }

    public String getTurNombre() {
        return turNombre;
    }

    public void setTurNombre(String turNombre) {
        this.turNombre = turNombre;
    }

    public String getTurDescrip() {
        return turDescrip;
    }

    public void setTurDescrip(String turDescrip) {
        this.turDescrip = turDescrip;
    }

    public BigInteger getTurEstado() {
        return turEstado;
    }

    public void setTurEstado(BigInteger turEstado) {
        this.turEstado = turEstado;
    }

    public Date getTurDateEnd() {
        return turDateEnd;
    }

    public void setTurDateEnd(Date turDateEnd) {
        this.turDateEnd = turDateEnd;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turId != null ? turId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTurno)) {
            return false;
        }
        TTurno other = (TTurno) object;
        if ((this.turId == null && other.turId != null) || (this.turId != null && !this.turId.equals(other.turId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TTurno[ turId=" + turId + " ]";
    }

   
}

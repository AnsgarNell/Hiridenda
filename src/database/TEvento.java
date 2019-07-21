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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "T_EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEvento.findAll", query = "SELECT t FROM TEvento t"),
    @NamedQuery(name = "TEvento.findByEvtId", query = "SELECT t FROM TEvento t WHERE t.evtId = :evtId"),
    @NamedQuery(name = "TEvento.findByEvtLotId", query = "SELECT t FROM TEvento t WHERE t.evtLotId = :evtLotId"),
    @NamedQuery(name = "TEvento.findByEvtEstado", query = "SELECT t FROM TEvento t WHERE t.evtEstado = :evtEstado"),
    @NamedQuery(name = "TEvento.findByEvtDate", query = "SELECT t FROM TEvento t WHERE t.evtDate = :evtDate")})
public class TEvento implements Serializable {
    @Basic(optional = false)
    @Column(name = "EVT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date evtDate;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EVT_ID")
    private BigDecimal evtId;
    @Basic(optional = false)
    @Column(name = "EVT_LOT_ID")
    private String evtLotId;
    @Basic(optional = false)
    @Column(name = "EVT_ESTADO")
    private BigInteger evtEstado;
    @JoinColumn(name = "EVT_TUR_ID", referencedColumnName = "TUR_ID")
    @ManyToOne(optional = false)
    private TTurno evtTurId;
    @JoinColumn(name = "EVT_LOC_ID", referencedColumnName = "LOC_ID")
    @ManyToOne(optional = false)
    private TLocalizacion evtLocId;

    public TEvento() {
    }

    public TEvento(BigDecimal evtId) {
        this.evtId = evtId;
    }

    public TEvento(BigDecimal evtId, String evtLotId, BigInteger evtEstado, Date evtDate) {
        this.evtId = evtId;
        this.evtLotId = evtLotId;
        this.evtEstado = evtEstado;
        this.evtDate = evtDate;
    }

    public BigDecimal getEvtId() {
        return evtId;
    }

    public void setEvtId(BigDecimal evtId) {
        this.evtId = evtId;
    }

    public String getEvtLotId() {
        return evtLotId;
    }

    public void setEvtLotId(String evtLotId) {
        this.evtLotId = evtLotId;
    }

    public BigInteger getEvtEstado() {
        return evtEstado;
    }

    public void setEvtEstado(BigInteger evtEstado) {
        this.evtEstado = evtEstado;
    }

    public Date getEvtDate() {
        return evtDate;
    }

    public void setEvtDate(Date evtDate) {
        this.evtDate = evtDate;
    }

    public TTurno getEvtTurId() {
        return evtTurId;
    }

    public void setEvtTurId(TTurno evtTurId) {
        this.evtTurId = evtTurId;
    }

    public TLocalizacion getEvtLocId() {
        return evtLocId;
    }

    public void setEvtLocId(TLocalizacion evtLocId) {
        this.evtLocId = evtLocId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evtId != null ? evtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEvento)) {
            return false;
        }
        TEvento other = (TEvento) object;
        if ((this.evtId == null && other.evtId != null) || (this.evtId != null && !this.evtId.equals(other.evtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TEvento[ evtId=" + evtId + " ]";
    }   
}

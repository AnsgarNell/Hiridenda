/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author InAns
 */
@Entity
@Table(name = "T_EVT_MAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEvtMag.findAll", query = "SELECT t FROM TEvtMag t"),
    @NamedQuery(name = "TEvtMag.findByEvtmagId", query = "SELECT t FROM TEvtMag t WHERE t.tEvtMagPK.evtmagId = :evtmagId"),
    @NamedQuery(name = "TEvtMag.findByEvtmagLotId", query = "SELECT t FROM TEvtMag t WHERE t.evtmagLotId = :evtmagLotId"),
    @NamedQuery(name = "TEvtMag.findByEvtmagMagId", query = "SELECT t FROM TEvtMag t WHERE t.tEvtMagPK.evtmagMagId = :evtmagMagId"),
    @NamedQuery(name = "TEvtMag.findByEvtmagValor", query = "SELECT t FROM TEvtMag t WHERE t.evtmagValor = :evtmagValor"),
    @NamedQuery(name = "TEvtMag.findByEvtmagEstado", query = "SELECT t FROM TEvtMag t WHERE t.evtmagEstado = :evtmagEstado")})
public class TEvtMag implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TEvtMagPK tEvtMagPK;
    @Basic(optional = false)
    @Column(name = "EVTMAG_LOT_ID")
    private String evtmagLotId;
    @Basic(optional = false)
    @Column(name = "EVTMAG_VALOR")
    private BigInteger evtmagValor;
    @Basic(optional = false)
    @Column(name = "EVTMAG_ESTADO")
    private BigInteger evtmagEstado;
    @JoinColumn(name = "EVTMAG_MAG_ID", referencedColumnName = "MAG_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TMagnitud tMagnitud;
    @JoinColumn(name = "EVTMAG_ID", referencedColumnName = "EVT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TEvento tEvento;

    public TEvtMag() {
    }

    public TEvtMag(TEvtMagPK tEvtMagPK) {
        this.tEvtMagPK = tEvtMagPK;
    }

    public TEvtMag(TEvtMagPK tEvtMagPK, String evtmagLotId, BigInteger evtmagValor, BigInteger evtmagEstado) {
        this.tEvtMagPK = tEvtMagPK;
        this.evtmagLotId = evtmagLotId;
        this.evtmagValor = evtmagValor;
        this.evtmagEstado = evtmagEstado;
    }

    public TEvtMag(BigInteger evtmagId, BigInteger evtmagMagId) {
        this.tEvtMagPK = new TEvtMagPK(evtmagId, evtmagMagId);
    }

    public TEvtMagPK getTEvtMagPK() {
        return tEvtMagPK;
    }

    public void setTEvtMagPK(TEvtMagPK tEvtMagPK) {
        this.tEvtMagPK = tEvtMagPK;
    }

    public String getEvtmagLotId() {
        return evtmagLotId;
    }

    public void setEvtmagLotId(String evtmagLotId) {
        this.evtmagLotId = evtmagLotId;
    }

    public BigInteger getEvtmagValor() {
        return evtmagValor;
    }

    public void setEvtmagValor(BigInteger evtmagValor) {
        this.evtmagValor = evtmagValor;
    }

    public BigInteger getEvtmagEstado() {
        return evtmagEstado;
    }

    public void setEvtmagEstado(BigInteger evtmagEstado) {
        this.evtmagEstado = evtmagEstado;
    }

    public TMagnitud getTMagnitud() {
        return tMagnitud;
    }

    public void setTMagnitud(TMagnitud tMagnitud) {
        this.tMagnitud = tMagnitud;
    }

    public TEvento getTEvento() {
        return tEvento;
    }

    public void setTEvento(TEvento tEvento) {
        this.tEvento = tEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tEvtMagPK != null ? tEvtMagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEvtMag)) {
            return false;
        }
        TEvtMag other = (TEvtMag) object;
        if ((this.tEvtMagPK == null && other.tEvtMagPK != null) || (this.tEvtMagPK != null && !this.tEvtMagPK.equals(other.tEvtMagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TEvtMag[ tEvtMagPK=" + tEvtMagPK + " ]";
    }
    
}

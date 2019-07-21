/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author InAns
 */
@Embeddable
public class TEvtMagPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "EVTMAG_ID")
    private BigInteger evtmagId;
    @Basic(optional = false)
    @Column(name = "EVTMAG_MAG_ID")
    private BigInteger evtmagMagId;

    public TEvtMagPK() {
    }

    public TEvtMagPK(BigInteger evtmagId, BigInteger evtmagMagId) {
        this.evtmagId = evtmagId;
        this.evtmagMagId = evtmagMagId;
    }

    public BigInteger getEvtmagId() {
        return evtmagId;
    }

    public void setEvtmagId(BigInteger evtmagId) {
        this.evtmagId = evtmagId;
    }

    public BigInteger getEvtmagMagId() {
        return evtmagMagId;
    }

    public void setEvtmagMagId(BigInteger evtmagMagId) {
        this.evtmagMagId = evtmagMagId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evtmagId != null ? evtmagId.hashCode() : 0);
        hash += (evtmagMagId != null ? evtmagMagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEvtMagPK)) {
            return false;
        }
        TEvtMagPK other = (TEvtMagPK) object;
        if ((this.evtmagId == null && other.evtmagId != null) || (this.evtmagId != null && !this.evtmagId.equals(other.evtmagId))) {
            return false;
        }
        if ((this.evtmagMagId == null && other.evtmagMagId != null) || (this.evtmagMagId != null && !this.evtmagMagId.equals(other.evtmagMagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TEvtMagPK[ evtmagId=" + evtmagId + ", evtmagMagId=" + evtmagMagId + " ]";
    }
    
}

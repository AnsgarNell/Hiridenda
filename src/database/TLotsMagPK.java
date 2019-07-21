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
public class TLotsMagPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "LOTMAG_LOTS_ID")
    private String lotmagLotsId;
    @Basic(optional = false)
    @Column(name = "LOTMAG_MAG_ID")
    private BigInteger lotmagMagId;

    public TLotsMagPK() {
    }

    public TLotsMagPK(String lotmagLotsId, BigInteger lotmagMagId) {
        this.lotmagLotsId = lotmagLotsId;
        this.lotmagMagId = lotmagMagId;
    }

    public String getLotmagLotsId() {
        return lotmagLotsId;
    }

    public void setLotmagLotsId(String lotmagLotsId) {
        this.lotmagLotsId = lotmagLotsId;
    }

    public BigInteger getLotmagMagId() {
        return lotmagMagId;
    }

    public void setLotmagMagId(BigInteger lotmagMagId) {
        this.lotmagMagId = lotmagMagId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lotmagLotsId != null ? lotmagLotsId.hashCode() : 0);
        hash += (lotmagMagId != null ? lotmagMagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLotsMagPK)) {
            return false;
        }
        TLotsMagPK other = (TLotsMagPK) object;
        if ((this.lotmagLotsId == null && other.lotmagLotsId != null) || (this.lotmagLotsId != null && !this.lotmagLotsId.equals(other.lotmagLotsId))) {
            return false;
        }
        if ((this.lotmagMagId == null && other.lotmagMagId != null) || (this.lotmagMagId != null && !this.lotmagMagId.equals(other.lotmagMagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLotsMagPK[ lotmagLotsId=" + lotmagLotsId + ", lotmagMagId=" + lotmagMagId + " ]";
    }
    
}

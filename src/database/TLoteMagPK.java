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
public class TLoteMagPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "LOTMAG_LOTE_ID")
    private String lotmagLoteId;
    @Basic(optional = false)
    @Column(name = "LOTMAG_MAG_ID")
    private BigInteger lotmagMagId;

    public TLoteMagPK() {
    }

    public TLoteMagPK(String lotmagLoteId, BigInteger lotmagMagId) {
        this.lotmagLoteId = lotmagLoteId;
        this.lotmagMagId = lotmagMagId;
    }

    public String getLotmagLoteId() {
        return lotmagLoteId;
    }

    public void setLotmagLoteId(String lotmagLoteId) {
        this.lotmagLoteId = lotmagLoteId;
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
        hash += (lotmagLoteId != null ? lotmagLoteId.hashCode() : 0);
        hash += (lotmagMagId != null ? lotmagMagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteMagPK)) {
            return false;
        }
        TLoteMagPK other = (TLoteMagPK) object;
        if ((this.lotmagLoteId == null && other.lotmagLoteId != null) || (this.lotmagLoteId != null && !this.lotmagLoteId.equals(other.lotmagLoteId))) {
            return false;
        }
        if ((this.lotmagMagId == null && other.lotmagMagId != null) || (this.lotmagMagId != null && !this.lotmagMagId.equals(other.lotmagMagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteMagPK[ lotmagLoteId=" + lotmagLoteId + ", lotmagMagId=" + lotmagMagId + " ]";
    }
    
}

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
public class TLotrMagPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "LOTMAG_LOTR_ID")
    private String lotmagLotrId;
    @Basic(optional = false)
    @Column(name = "LOTMAG_MAG_ID")
    private BigInteger lotmagMagId;

    public TLotrMagPK() {
    }

    public TLotrMagPK(String lotmagLotrId, BigInteger lotmagMagId) {
        this.lotmagLotrId = lotmagLotrId;
        this.lotmagMagId = lotmagMagId;
    }

    public String getLotmagLotrId() {
        return lotmagLotrId;
    }

    public void setLotmagLotrId(String lotmagLotrId) {
        this.lotmagLotrId = lotmagLotrId;
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
        hash += (lotmagLotrId != null ? lotmagLotrId.hashCode() : 0);
        hash += (lotmagMagId != null ? lotmagMagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLotrMagPK)) {
            return false;
        }
        TLotrMagPK other = (TLotrMagPK) object;
        if ((this.lotmagLotrId == null && other.lotmagLotrId != null) || (this.lotmagLotrId != null && !this.lotmagLotrId.equals(other.lotmagLotrId))) {
            return false;
        }
        if ((this.lotmagMagId == null && other.lotmagMagId != null) || (this.lotmagMagId != null && !this.lotmagMagId.equals(other.lotmagMagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLotrMagPK[ lotmagLotrId=" + lotmagLotrId + ", lotmagMagId=" + lotmagMagId + " ]";
    }
    
}

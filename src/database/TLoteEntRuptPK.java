/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author InAns
 */
@Embeddable
public class TLoteEntRuptPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "LOER_LOTE_ID")
    private String loerLoteId;
    @Basic(optional = false)
    @Column(name = "LOER_LOTR_ID")
    private String loerLotrId;

    public TLoteEntRuptPK() {
    }

    public TLoteEntRuptPK(String loerLoteId, String loerLotrId) {
        this.loerLoteId = loerLoteId;
        this.loerLotrId = loerLotrId;
    }

    public String getLoerLoteId() {
        return loerLoteId;
    }

    public void setLoerLoteId(String loerLoteId) {
        this.loerLoteId = loerLoteId;
    }

    public String getLoerLotrId() {
        return loerLotrId;
    }

    public void setLoerLotrId(String loerLotrId) {
        this.loerLotrId = loerLotrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loerLoteId != null ? loerLoteId.hashCode() : 0);
        hash += (loerLotrId != null ? loerLotrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteEntRuptPK)) {
            return false;
        }
        TLoteEntRuptPK other = (TLoteEntRuptPK) object;
        if ((this.loerLoteId == null && other.loerLoteId != null) || (this.loerLoteId != null && !this.loerLoteId.equals(other.loerLoteId))) {
            return false;
        }
        if ((this.loerLotrId == null && other.loerLotrId != null) || (this.loerLotrId != null && !this.loerLotrId.equals(other.loerLotrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteEntRuptPK[ loerLoteId=" + loerLoteId + ", loerLotrId=" + loerLotrId + " ]";
    }
    
}

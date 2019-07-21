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
public class TLoteEntSalPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "LOES_LOTE_ID")
    private String loesLoteId;
    @Basic(optional = false)
    @Column(name = "LOES_LOTS_ID")
    private String loesLotsId;

    public TLoteEntSalPK() {
    }

    public TLoteEntSalPK(String loesLoteId, String loesLotsId) {
        this.loesLoteId = loesLoteId;
        this.loesLotsId = loesLotsId;
    }

    public String getLoesLoteId() {
        return loesLoteId;
    }

    public void setLoesLoteId(String loesLoteId) {
        this.loesLoteId = loesLoteId;
    }

    public String getLoesLotsId() {
        return loesLotsId;
    }

    public void setLoesLotsId(String loesLotsId) {
        this.loesLotsId = loesLotsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loesLoteId != null ? loesLoteId.hashCode() : 0);
        hash += (loesLotsId != null ? loesLotsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteEntSalPK)) {
            return false;
        }
        TLoteEntSalPK other = (TLoteEntSalPK) object;
        if ((this.loesLoteId == null && other.loesLoteId != null) || (this.loesLoteId != null && !this.loesLoteId.equals(other.loesLoteId))) {
            return false;
        }
        if ((this.loesLotsId == null && other.loesLotsId != null) || (this.loesLotsId != null && !this.loesLotsId.equals(other.loesLotsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteEntSalPK[ loesLoteId=" + loesLoteId + ", loesLotsId=" + loesLotsId + " ]";
    }
    
}

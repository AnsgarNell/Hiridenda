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
public class TLoteUniPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "LOTUNI_UNI_ID")
    private String lotuniUniId;
    @Basic(optional = false)
    @Column(name = "LOTUNI_LOTE_ID")
    private String lotuniLoteId;

    public TLoteUniPK() {
    }

    public TLoteUniPK(String lotuniUniId, String lotuniLoteId) {
        this.lotuniUniId = lotuniUniId;
        this.lotuniLoteId = lotuniLoteId;
    }

    public String getLotuniUniId() {
        return lotuniUniId;
    }

    public void setLotuniUniId(String lotuniUniId) {
        this.lotuniUniId = lotuniUniId;
    }

    public String getLotuniLoteId() {
        return lotuniLoteId;
    }

    public void setLotuniLoteId(String lotuniLoteId) {
        this.lotuniLoteId = lotuniLoteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lotuniUniId != null ? lotuniUniId.hashCode() : 0);
        hash += (lotuniLoteId != null ? lotuniLoteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteUniPK)) {
            return false;
        }
        TLoteUniPK other = (TLoteUniPK) object;
        if ((this.lotuniUniId == null && other.lotuniUniId != null) || (this.lotuniUniId != null && !this.lotuniUniId.equals(other.lotuniUniId))) {
            return false;
        }
        if ((this.lotuniLoteId == null && other.lotuniLoteId != null) || (this.lotuniLoteId != null && !this.lotuniLoteId.equals(other.lotuniLoteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteUniPK[ lotuniUniId=" + lotuniUniId + ", lotuniLoteId=" + lotuniLoteId + " ]";
    }
    
}

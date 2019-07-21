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
public class TLoteRuptSalPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "LORS_LOTR_ID")
    private String lorsLotrId;
    @Basic(optional = false)
    @Column(name = "LORS_LOTS_ID")
    private String lorsLotsId;

    public TLoteRuptSalPK() {
    }

    public TLoteRuptSalPK(String lorsLotrId, String lorsLotsId) {
        this.lorsLotrId = lorsLotrId;
        this.lorsLotsId = lorsLotsId;
    }

    public String getLorsLotrId() {
        return lorsLotrId;
    }

    public void setLorsLotrId(String lorsLotrId) {
        this.lorsLotrId = lorsLotrId;
    }

    public String getLorsLotsId() {
        return lorsLotsId;
    }

    public void setLorsLotsId(String lorsLotsId) {
        this.lorsLotsId = lorsLotsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lorsLotrId != null ? lorsLotrId.hashCode() : 0);
        hash += (lorsLotsId != null ? lorsLotsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteRuptSalPK)) {
            return false;
        }
        TLoteRuptSalPK other = (TLoteRuptSalPK) object;
        if ((this.lorsLotrId == null && other.lorsLotrId != null) || (this.lorsLotrId != null && !this.lorsLotrId.equals(other.lorsLotrId))) {
            return false;
        }
        if ((this.lorsLotsId == null && other.lorsLotsId != null) || (this.lorsLotsId != null && !this.lorsLotsId.equals(other.lorsLotsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteRuptSalPK[ lorsLotrId=" + lorsLotrId + ", lorsLotsId=" + lorsLotsId + " ]";
    }
    
}

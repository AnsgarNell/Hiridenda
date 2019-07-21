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
@Table(name = "T_LOTE_RUPT_SAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLoteRuptSal.findAll", query = "SELECT t FROM TLoteRuptSal t"),
    @NamedQuery(name = "TLoteRuptSal.findByLorsLotrId", query = "SELECT t FROM TLoteRuptSal t WHERE t.tLoteRuptSalPK.lorsLotrId = :lorsLotrId"),
    @NamedQuery(name = "TLoteRuptSal.findByLorsLotsId", query = "SELECT t FROM TLoteRuptSal t WHERE t.tLoteRuptSalPK.lorsLotsId = :lorsLotsId"),
    @NamedQuery(name = "TLoteRuptSal.findByLorsCant", query = "SELECT t FROM TLoteRuptSal t WHERE t.lorsCant = :lorsCant")})
public class TLoteRuptSal implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TLoteRuptSalPK tLoteRuptSalPK;
    @Basic(optional = false)
    @Column(name = "LORS_CANT")
    private BigInteger lorsCant;
    @JoinColumn(name = "LORS_LOTS_ID", referencedColumnName = "LOTS_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TLoteSal tLoteSal;
    @JoinColumn(name = "LORS_LOTR_ID", referencedColumnName = "LOTR_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TLoteRupt tLoteRupt;

    public TLoteRuptSal() {
    }

    public TLoteRuptSal(TLoteRuptSalPK tLoteRuptSalPK) {
        this.tLoteRuptSalPK = tLoteRuptSalPK;
    }

    public TLoteRuptSal(TLoteRuptSalPK tLoteRuptSalPK, BigInteger lorsCant) {
        this.tLoteRuptSalPK = tLoteRuptSalPK;
        this.lorsCant = lorsCant;
    }

    public TLoteRuptSal(String lorsLotrId, String lorsLotsId) {
        this.tLoteRuptSalPK = new TLoteRuptSalPK(lorsLotrId, lorsLotsId);
    }

    public TLoteRuptSalPK getTLoteRuptSalPK() {
        return tLoteRuptSalPK;
    }

    public void setTLoteRuptSalPK(TLoteRuptSalPK tLoteRuptSalPK) {
        this.tLoteRuptSalPK = tLoteRuptSalPK;
    }

    public BigInteger getLorsCant() {
        return lorsCant;
    }

    public void setLorsCant(BigInteger lorsCant) {
        this.lorsCant = lorsCant;
    }

    public TLoteSal getTLoteSal() {
        return tLoteSal;
    }

    public void setTLoteSal(TLoteSal tLoteSal) {
        this.tLoteSal = tLoteSal;
    }

    public TLoteRupt getTLoteRupt() {
        return tLoteRupt;
    }

    public void setTLoteRupt(TLoteRupt tLoteRupt) {
        this.tLoteRupt = tLoteRupt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tLoteRuptSalPK != null ? tLoteRuptSalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteRuptSal)) {
            return false;
        }
        TLoteRuptSal other = (TLoteRuptSal) object;
        if ((this.tLoteRuptSalPK == null && other.tLoteRuptSalPK != null) || (this.tLoteRuptSalPK != null && !this.tLoteRuptSalPK.equals(other.tLoteRuptSalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteRuptSal[ tLoteRuptSalPK=" + tLoteRuptSalPK + " ]";
    }
    
}

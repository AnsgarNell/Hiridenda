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
@Table(name = "T_LOTE_ENT_SAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLoteEntSal.findAll", query = "SELECT t FROM TLoteEntSal t"),
    @NamedQuery(name = "TLoteEntSal.findByLoesLoteId", query = "SELECT t FROM TLoteEntSal t WHERE t.tLoteEntSalPK.loesLoteId = :loesLoteId"),
    @NamedQuery(name = "TLoteEntSal.findByLoesLotsId", query = "SELECT t FROM TLoteEntSal t WHERE t.tLoteEntSalPK.loesLotsId = :loesLotsId"),
    @NamedQuery(name = "TLoteEntSal.findByLoesCant", query = "SELECT t FROM TLoteEntSal t WHERE t.loesCant = :loesCant")})
public class TLoteEntSal implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TLoteEntSalPK tLoteEntSalPK;
    @Basic(optional = false)
    @Column(name = "LOES_CANT")
    private BigInteger loesCant;
    @JoinColumn(name = "LOES_LOTS_ID", referencedColumnName = "LOTS_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TLoteSal tLoteSal;
    @JoinColumn(name = "LOES_LOTE_ID", referencedColumnName = "LOTE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TLoteEnt tLoteEnt;

    public TLoteEntSal() {
    }

    public TLoteEntSal(TLoteEntSalPK tLoteEntSalPK) {
        this.tLoteEntSalPK = tLoteEntSalPK;
    }

    public TLoteEntSal(TLoteEntSalPK tLoteEntSalPK, BigInteger loesCant) {
        this.tLoteEntSalPK = tLoteEntSalPK;
        this.loesCant = loesCant;
    }

    public TLoteEntSal(String loesLoteId, String loesLotsId) {
        this.tLoteEntSalPK = new TLoteEntSalPK(loesLoteId, loesLotsId);
    }

    public TLoteEntSalPK getTLoteEntSalPK() {
        return tLoteEntSalPK;
    }

    public void setTLoteEntSalPK(TLoteEntSalPK tLoteEntSalPK) {
        this.tLoteEntSalPK = tLoteEntSalPK;
    }

    public BigInteger getLoesCant() {
        return loesCant;
    }

    public void setLoesCant(BigInteger loesCant) {
        this.loesCant = loesCant;
    }

    public TLoteSal getTLoteSal() {
        return tLoteSal;
    }

    public void setTLoteSal(TLoteSal tLoteSal) {
        this.tLoteSal = tLoteSal;
    }

    public TLoteEnt getTLoteEnt() {
        return tLoteEnt;
    }

    public void setTLoteEnt(TLoteEnt tLoteEnt) {
        this.tLoteEnt = tLoteEnt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tLoteEntSalPK != null ? tLoteEntSalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteEntSal)) {
            return false;
        }
        TLoteEntSal other = (TLoteEntSal) object;
        if ((this.tLoteEntSalPK == null && other.tLoteEntSalPK != null) || (this.tLoteEntSalPK != null && !this.tLoteEntSalPK.equals(other.tLoteEntSalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteEntSal[ tLoteEntSalPK=" + tLoteEntSalPK + " ]";
    }
    
}

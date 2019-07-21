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
@Table(name = "T_LOTE_ENT_RUPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLoteEntRupt.findAll", query = "SELECT t FROM TLoteEntRupt t"),
    @NamedQuery(name = "TLoteEntRupt.findByLoerLoteId", query = "SELECT t FROM TLoteEntRupt t WHERE t.tLoteEntRuptPK.loerLoteId = :loerLoteId"),
    @NamedQuery(name = "TLoteEntRupt.findByLoerLotrId", query = "SELECT t FROM TLoteEntRupt t WHERE t.tLoteEntRuptPK.loerLotrId = :loerLotrId"),
    @NamedQuery(name = "TLoteEntRupt.findByLoerCant", query = "SELECT t FROM TLoteEntRupt t WHERE t.loerCant = :loerCant")})
public class TLoteEntRupt implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TLoteEntRuptPK tLoteEntRuptPK;
    @Basic(optional = false)
    @Column(name = "LOER_CANT")
    private BigInteger loerCant;
    @JoinColumn(name = "LOER_LOTR_ID", referencedColumnName = "LOTR_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TLoteRupt tLoteRupt;
    @JoinColumn(name = "LOER_LOTE_ID", referencedColumnName = "LOTE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TLoteEnt tLoteEnt;

    public TLoteEntRupt() {
    }

    public TLoteEntRupt(TLoteEntRuptPK tLoteEntRuptPK) {
        this.tLoteEntRuptPK = tLoteEntRuptPK;
    }

    public TLoteEntRupt(TLoteEntRuptPK tLoteEntRuptPK, BigInteger loerCant) {
        this.tLoteEntRuptPK = tLoteEntRuptPK;
        this.loerCant = loerCant;
    }

    public TLoteEntRupt(String loerLoteId, String loerLotrId) {
        this.tLoteEntRuptPK = new TLoteEntRuptPK(loerLoteId, loerLotrId);
    }

    public TLoteEntRuptPK getTLoteEntRuptPK() {
        return tLoteEntRuptPK;
    }

    public void setTLoteEntRuptPK(TLoteEntRuptPK tLoteEntRuptPK) {
        this.tLoteEntRuptPK = tLoteEntRuptPK;
    }

    public BigInteger getLoerCant() {
        return loerCant;
    }

    public void setLoerCant(BigInteger loerCant) {
        this.loerCant = loerCant;
    }

    public TLoteRupt getTLoteRupt() {
        return tLoteRupt;
    }

    public void setTLoteRupt(TLoteRupt tLoteRupt) {
        this.tLoteRupt = tLoteRupt;
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
        hash += (tLoteEntRuptPK != null ? tLoteEntRuptPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteEntRupt)) {
            return false;
        }
        TLoteEntRupt other = (TLoteEntRupt) object;
        if ((this.tLoteEntRuptPK == null && other.tLoteEntRuptPK != null) || (this.tLoteEntRuptPK != null && !this.tLoteEntRuptPK.equals(other.tLoteEntRuptPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteEntRupt[ tLoteEntRuptPK=" + tLoteEntRuptPK + " ]";
    }
    
}

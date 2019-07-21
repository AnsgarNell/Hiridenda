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
@Table(name = "T_LOTR_MAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLotrMag.findAll", query = "SELECT t FROM TLotrMag t"),
    @NamedQuery(name = "TLotrMag.findByLotmagLotrId", query = "SELECT t FROM TLotrMag t WHERE t.tLotrMagPK.lotmagLotrId = :lotmagLotrId"),
    @NamedQuery(name = "TLotrMag.findByLotmagMagId", query = "SELECT t FROM TLotrMag t WHERE t.tLotrMagPK.lotmagMagId = :lotmagMagId"),
    @NamedQuery(name = "TLotrMag.findByLotmagMax", query = "SELECT t FROM TLotrMag t WHERE t.lotmagMax = :lotmagMax"),
    @NamedQuery(name = "TLotrMag.findByLotmagMin", query = "SELECT t FROM TLotrMag t WHERE t.lotmagMin = :lotmagMin"),
    @NamedQuery(name = "TLotrMag.findByLotmagTrack", query = "SELECT t FROM TLotrMag t WHERE t.lotmagTrack = :lotmagTrack")})
public class TLotrMag implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TLotrMagPK tLotrMagPK;
    @Column(name = "LOTMAG_MAX")
    private BigInteger lotmagMax;
    @Column(name = "LOTMAG_MIN")
    private BigInteger lotmagMin;
    @Basic(optional = false)
    @Column(name = "LOTMAG_TRACK")
    private BigInteger lotmagTrack;
    @JoinColumn(name = "LOTMAG_MAG_ID", referencedColumnName = "MAG_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TMagnitud tMagnitud;
    @JoinColumn(name = "LOTMAG_LOTR_ID", referencedColumnName = "LOTR_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TLoteRupt tLoteRupt;

    public TLotrMag() {
    }

    public TLotrMag(TLotrMagPK tLotrMagPK) {
        this.tLotrMagPK = tLotrMagPK;
    }

    public TLotrMag(TLotrMagPK tLotrMagPK, BigInteger lotmagTrack) {
        this.tLotrMagPK = tLotrMagPK;
        this.lotmagTrack = lotmagTrack;
    }

    public TLotrMag(String lotmagLotrId, BigInteger lotmagMagId) {
        this.tLotrMagPK = new TLotrMagPK(lotmagLotrId, lotmagMagId);
    }

    public TLotrMagPK getTLotrMagPK() {
        return tLotrMagPK;
    }

    public void setTLotrMagPK(TLotrMagPK tLotrMagPK) {
        this.tLotrMagPK = tLotrMagPK;
    }

    public BigInteger getLotmagMax() {
        return lotmagMax;
    }

    public void setLotmagMax(BigInteger lotmagMax) {
        this.lotmagMax = lotmagMax;
    }

    public BigInteger getLotmagMin() {
        return lotmagMin;
    }

    public void setLotmagMin(BigInteger lotmagMin) {
        this.lotmagMin = lotmagMin;
    }

    public BigInteger getLotmagTrack() {
        return lotmagTrack;
    }

    public void setLotmagTrack(BigInteger lotmagTrack) {
        this.lotmagTrack = lotmagTrack;
    }

    public TMagnitud getTMagnitud() {
        return tMagnitud;
    }

    public void setTMagnitud(TMagnitud tMagnitud) {
        this.tMagnitud = tMagnitud;
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
        hash += (tLotrMagPK != null ? tLotrMagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLotrMag)) {
            return false;
        }
        TLotrMag other = (TLotrMag) object;
        if ((this.tLotrMagPK == null && other.tLotrMagPK != null) || (this.tLotrMagPK != null && !this.tLotrMagPK.equals(other.tLotrMagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLotrMag[ tLotrMagPK=" + tLotrMagPK + " ]";
    }
    
}

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
@Table(name = "T_LOTE_MAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLoteMag.findAll", query = "SELECT t FROM TLoteMag t"),
    @NamedQuery(name = "TLoteMag.findByLotmagLoteId", query = "SELECT t FROM TLoteMag t WHERE t.tLoteMagPK.lotmagLoteId = :lotmagLoteId"),
    @NamedQuery(name = "TLoteMag.findByLotmagMagId", query = "SELECT t FROM TLoteMag t WHERE t.tLoteMagPK.lotmagMagId = :lotmagMagId"),
    @NamedQuery(name = "TLoteMag.findByLotmagMax", query = "SELECT t FROM TLoteMag t WHERE t.lotmagMax = :lotmagMax"),
    @NamedQuery(name = "TLoteMag.findByLotmagMin", query = "SELECT t FROM TLoteMag t WHERE t.lotmagMin = :lotmagMin"),
    @NamedQuery(name = "TLoteMag.findByLotmagTrack", query = "SELECT t FROM TLoteMag t WHERE t.lotmagTrack = :lotmagTrack")})
public class TLoteMag implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TLoteMagPK tLoteMagPK;
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
    @JoinColumn(name = "LOTMAG_LOTE_ID", referencedColumnName = "LOTE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TLoteEnt tLoteEnt;

    public TLoteMag() {
    }

    public TLoteMag(TLoteMagPK tLoteMagPK) {
        this.tLoteMagPK = tLoteMagPK;
    }

    public TLoteMag(TLoteMagPK tLoteMagPK, BigInteger lotmagTrack) {
        this.tLoteMagPK = tLoteMagPK;
        this.lotmagTrack = lotmagTrack;
    }

    public TLoteMag(String lotmagLoteId, BigInteger lotmagMagId) {
        this.tLoteMagPK = new TLoteMagPK(lotmagLoteId, lotmagMagId);
    }

    public TLoteMagPK getTLoteMagPK() {
        return tLoteMagPK;
    }

    public void setTLoteMagPK(TLoteMagPK tLoteMagPK) {
        this.tLoteMagPK = tLoteMagPK;
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

    public TLoteEnt getTLoteEnt() {
        return tLoteEnt;
    }

    public void setTLoteEnt(TLoteEnt tLoteEnt) {
        this.tLoteEnt = tLoteEnt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tLoteMagPK != null ? tLoteMagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteMag)) {
            return false;
        }
        TLoteMag other = (TLoteMag) object;
        if ((this.tLoteMagPK == null && other.tLoteMagPK != null) || (this.tLoteMagPK != null && !this.tLoteMagPK.equals(other.tLoteMagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteMag[ tLoteMagPK=" + tLoteMagPK + " ]";
    }
    
}

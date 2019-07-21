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
@Table(name = "T_LOTS_MAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLotsMag.findAll", query = "SELECT t FROM TLotsMag t"),
    @NamedQuery(name = "TLotsMag.findByLotmagLotsId", query = "SELECT t FROM TLotsMag t WHERE t.tLotsMagPK.lotmagLotsId = :lotmagLotsId"),
    @NamedQuery(name = "TLotsMag.findByLotmagMagId", query = "SELECT t FROM TLotsMag t WHERE t.tLotsMagPK.lotmagMagId = :lotmagMagId"),
    @NamedQuery(name = "TLotsMag.findByLotmagMax", query = "SELECT t FROM TLotsMag t WHERE t.lotmagMax = :lotmagMax"),
    @NamedQuery(name = "TLotsMag.findByLotmagMin", query = "SELECT t FROM TLotsMag t WHERE t.lotmagMin = :lotmagMin"),
    @NamedQuery(name = "TLotsMag.findByLotmagTrack", query = "SELECT t FROM TLotsMag t WHERE t.lotmagTrack = :lotmagTrack")})
public class TLotsMag implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TLotsMagPK tLotsMagPK;
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
    @JoinColumn(name = "LOTMAG_LOTS_ID", referencedColumnName = "LOTS_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TLoteSal tLoteSal;

    public TLotsMag() {
    }

    public TLotsMag(TLotsMagPK tLotsMagPK) {
        this.tLotsMagPK = tLotsMagPK;
    }

    public TLotsMag(TLotsMagPK tLotsMagPK, BigInteger lotmagTrack) {
        this.tLotsMagPK = tLotsMagPK;
        this.lotmagTrack = lotmagTrack;
    }

    public TLotsMag(String lotmagLotsId, BigInteger lotmagMagId) {
        this.tLotsMagPK = new TLotsMagPK(lotmagLotsId, lotmagMagId);
    }

    public TLotsMagPK getTLotsMagPK() {
        return tLotsMagPK;
    }

    public void setTLotsMagPK(TLotsMagPK tLotsMagPK) {
        this.tLotsMagPK = tLotsMagPK;
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

    public TLoteSal getTLoteSal() {
        return tLoteSal;
    }

    public void setTLoteSal(TLoteSal tLoteSal) {
        this.tLoteSal = tLoteSal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tLotsMagPK != null ? tLotsMagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLotsMag)) {
            return false;
        }
        TLotsMag other = (TLotsMag) object;
        if ((this.tLotsMagPK == null && other.tLotsMagPK != null) || (this.tLotsMagPK != null && !this.tLotsMagPK.equals(other.tLotsMagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLotsMag[ tLotsMagPK=" + tLotsMagPK + " ]";
    }
    
}

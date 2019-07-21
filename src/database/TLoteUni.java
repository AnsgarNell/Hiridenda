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
@Table(name = "T_LOTE_UNI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLoteUni.findAll", query = "SELECT t FROM TLoteUni t"),
    @NamedQuery(name = "TLoteUni.findByLotuniUniId", query = "SELECT t FROM TLoteUni t WHERE t.tLoteUniPK.lotuniUniId = :lotuniUniId"),
    @NamedQuery(name = "TLoteUni.findByLotuniLoteId", query = "SELECT t FROM TLoteUni t WHERE t.tLoteUniPK.lotuniLoteId = :lotuniLoteId"),
    @NamedQuery(name = "TLoteUni.findByLotuniCant", query = "SELECT t FROM TLoteUni t WHERE t.lotuniCant = :lotuniCant")})
public class TLoteUni implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TLoteUniPK tLoteUniPK;
    @Basic(optional = false)
    @Column(name = "LOTUNI_CANT")
    private BigInteger lotuniCant;
    @JoinColumn(name = "LOTUNI_UNI_ID", referencedColumnName = "UNI_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TUnidad tUnidad;
    @JoinColumn(name = "LOTUNI_LOTE_ID", referencedColumnName = "LOTE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TLoteEnt tLoteEnt;

    public TLoteUni() {
    }

    public TLoteUni(TLoteUniPK tLoteUniPK) {
        this.tLoteUniPK = tLoteUniPK;
    }

    public TLoteUni(TLoteUniPK tLoteUniPK, BigInteger lotuniCant) {
        this.tLoteUniPK = tLoteUniPK;
        this.lotuniCant = lotuniCant;
    }

    public TLoteUni(String lotuniUniId, String lotuniLoteId) {
        this.tLoteUniPK = new TLoteUniPK(lotuniUniId, lotuniLoteId);
    }

    public TLoteUniPK getTLoteUniPK() {
        return tLoteUniPK;
    }

    public void setTLoteUniPK(TLoteUniPK tLoteUniPK) {
        this.tLoteUniPK = tLoteUniPK;
    }

    public BigInteger getLotuniCant() {
        return lotuniCant;
    }

    public void setLotuniCant(BigInteger lotuniCant) {
        this.lotuniCant = lotuniCant;
    }

    public TUnidad getTUnidad() {
        return tUnidad;
    }

    public void setTUnidad(TUnidad tUnidad) {
        this.tUnidad = tUnidad;
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
        hash += (tLoteUniPK != null ? tLoteUniPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteUni)) {
            return false;
        }
        TLoteUni other = (TLoteUni) object;
        if ((this.tLoteUniPK == null && other.tLoteUniPK != null) || (this.tLoteUniPK != null && !this.tLoteUniPK.equals(other.tLoteUniPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteUni[ tLoteUniPK=" + tLoteUniPK + " ]";
    }
    
}

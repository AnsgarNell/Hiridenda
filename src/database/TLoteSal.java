/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author InAns
 */
@Entity
@Table(name = "T_LOTE_SAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLoteSal.findAll", query = "SELECT t FROM TLoteSal t"),
    @NamedQuery(name = "TLoteSal.findByLotsId", query = "SELECT t FROM TLoteSal t WHERE t.lotsId = :lotsId"),
    @NamedQuery(name = "TLoteSal.findByLotsDescrip", query = "SELECT t FROM TLoteSal t WHERE t.lotsDescrip = :lotsDescrip"),
    @NamedQuery(name = "TLoteSal.findByLotsDate", query = "SELECT t FROM TLoteSal t WHERE t.lotsDate = :lotsDate"),
    @NamedQuery(name = "TLoteSal.findByLotsCant", query = "SELECT t FROM TLoteSal t WHERE t.lotsCant = :lotsCant"),
    @NamedQuery(name = "TLoteSal.findByLotsCantAct", query = "SELECT t FROM TLoteSal t WHERE t.lotsCantAct = :lotsCantAct"),
    @NamedQuery(name = "TLoteSal.findByLotsContador", query = "SELECT t FROM TLoteSal t WHERE t.lotsContador = :lotsContador"),
    @NamedQuery(name = "TLoteSal.findByLotsEstado", query = "SELECT t FROM TLoteSal t WHERE t.lotsEstado = :lotsEstado"),
    @NamedQuery(name = "TLoteSal.findByLotsDateEnd", query = "SELECT t FROM TLoteSal t WHERE t.lotsDateEnd = :lotsDateEnd")})
public class TLoteSal implements Serializable {
    @Basic(optional =     false)
    @Column(name = "LOTS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lotsDate;
    @Column(name =     "LOTS_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lotsDateEnd;
   
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LOTS_ID")
    private String lotsId;
    @Column(name = "LOTS_DESCRIP")
    private String lotsDescrip;
    @Basic(optional = false)
    @Column(name = "LOTS_CANT")
    private BigInteger lotsCant;
    @Basic(optional = false)
    @Column(name = "LOTS_CANT_ACT")
    private BigInteger lotsCantAct;
    @Basic(optional = false)
    @Column(name = "LOTS_CONTADOR")
    private BigInteger lotsContador;
    @Basic(optional = false)
    @Column(name = "LOTS_ESTADO")
    private BigInteger lotsEstado;
    @JoinColumn(name = "LOTS_TUR_ID", referencedColumnName = "TUR_ID")
    @ManyToOne(optional = false)
    private TTurno lotsTurId;
    @JoinColumn(name = "LOTS_TUR_ID_END", referencedColumnName = "TUR_ID")
    @ManyToOne
    private TTurno lotsTurIdEnd;
    @JoinColumn(name = "LOTS_TAG_ID", referencedColumnName = "TAG_ID")
    @ManyToOne(optional = false)
    private TTag lotsTagId;
    @JoinColumn(name = "LOTS_LOC_ID", referencedColumnName = "LOC_ID")
    @ManyToOne(optional = false)
    private TLocalizacion lotsLocId;

    public TLoteSal() {
    }

    public TLoteSal(String lotsId) {
        this.lotsId = lotsId;
    }

    public TLoteSal(String lotsId, Date lotsDate, BigInteger lotsCant, BigInteger lotsCantAct, BigInteger lotsContador, BigInteger lotsEstado) {
        this.lotsId = lotsId;
        this.lotsDate = lotsDate;
        this.lotsCant = lotsCant;
        this.lotsCantAct = lotsCantAct;
        this.lotsContador = lotsContador;
        this.lotsEstado = lotsEstado;
    }

    public String getLotsId() {
        return lotsId;
    }

    public void setLotsId(String lotsId) {
        this.lotsId = lotsId;
    }

    public String getLotsDescrip() {
        return lotsDescrip;
    }

    public void setLotsDescrip(String lotsDescrip) {
        this.lotsDescrip = lotsDescrip;
    }

    public Date getLotsDate() {
        return lotsDate;
    }

    public void setLotsDate(Date lotsDate) {
        this.lotsDate = lotsDate;
    }

    public BigInteger getLotsCant() {
        return lotsCant;
    }

    public void setLotsCant(BigInteger lotsCant) {
        this.lotsCant = lotsCant;
    }

    public BigInteger getLotsCantAct() {
        return lotsCantAct;
    }

    public void setLotsCantAct(BigInteger lotsCantAct) {
        this.lotsCantAct = lotsCantAct;
    }

    public BigInteger getLotsContador() {
        return lotsContador;
    }

    public void setLotsContador(BigInteger lotsContador) {
        this.lotsContador = lotsContador;
    }

    public BigInteger getLotsEstado() {
        return lotsEstado;
    }

    public void setLotsEstado(BigInteger lotsEstado) {
        this.lotsEstado = lotsEstado;
    }

    public Date getLotsDateEnd() {
        return lotsDateEnd;
    }

    public void setLotsDateEnd(Date lotsDateEnd) {
        this.lotsDateEnd = lotsDateEnd;
    }

   

    public TTurno getLotsTurId() {
        return lotsTurId;
    }

    public void setLotsTurId(TTurno lotsTurId) {
        this.lotsTurId = lotsTurId;
    }

    public TTurno getLotsTurIdEnd() {
        return lotsTurIdEnd;
    }

    public void setLotsTurIdEnd(TTurno lotsTurIdEnd) {
        this.lotsTurIdEnd = lotsTurIdEnd;
    }

    public TTag getLotsTagId() {
        return lotsTagId;
    }

    public void setLotsTagId(TTag lotsTagId) {
        this.lotsTagId = lotsTagId;
    }

    public TLocalizacion getLotsLocId() {
        return lotsLocId;
    }

    public void setLotsLocId(TLocalizacion lotsLocId) {
        this.lotsLocId = lotsLocId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lotsId != null ? lotsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteSal)) {
            return false;
        }
        TLoteSal other = (TLoteSal) object;
        if ((this.lotsId == null && other.lotsId != null) || (this.lotsId != null && !this.lotsId.equals(other.lotsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteSal[ lotsId=" + lotsId + " ]";
    }

    
}

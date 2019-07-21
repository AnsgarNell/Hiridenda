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
@Table(name = "T_LOTE_ENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLoteEnt.findAll", query = "SELECT t FROM TLoteEnt t"),
    @NamedQuery(name = "TLoteEnt.findByLoteId", query = "SELECT t FROM TLoteEnt t WHERE t.loteId = :loteId"),
    @NamedQuery(name = "TLoteEnt.findByLoteDescrip", query = "SELECT t FROM TLoteEnt t WHERE t.loteDescrip = :loteDescrip"),
    @NamedQuery(name = "TLoteEnt.findByLoteDate", query = "SELECT t FROM TLoteEnt t WHERE t.loteDate = :loteDate"),
    @NamedQuery(name = "TLoteEnt.findByLoteCant", query = "SELECT t FROM TLoteEnt t WHERE t.loteCant = :loteCant"),
    @NamedQuery(name = "TLoteEnt.findByLoteCantAct", query = "SELECT t FROM TLoteEnt t WHERE t.loteCantAct = :loteCantAct"),
    @NamedQuery(name = "TLoteEnt.findByLoteContador", query = "SELECT t FROM TLoteEnt t WHERE t.loteContador = :loteContador"),
    @NamedQuery(name = "TLoteEnt.findByLoteEstado", query = "SELECT t FROM TLoteEnt t WHERE t.loteEstado = :loteEstado"),
    @NamedQuery(name = "TLoteEnt.findByLoteDateEnd", query = "SELECT t FROM TLoteEnt t WHERE t.loteDateEnd = :loteDateEnd")})
public class TLoteEnt implements Serializable {
    @Basic(optional =     false)
    @Column(name = "LOTE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loteDate;
    @Column(name =     "LOTE_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loteDateEnd;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LOTE_ID")
    private String loteId;
    @Column(name = "LOTE_DESCRIP")
    private String loteDescrip;
    @Basic(optional = false)
    @Column(name = "LOTE_CANT")
    private BigInteger loteCant;
    @Basic(optional = false)
    @Column(name = "LOTE_CANT_ACT")
    private BigInteger loteCantAct;
    @Basic(optional = false)
    @Column(name = "LOTE_CONTADOR")
    private BigInteger loteContador;
    @Basic(optional = false)
    @Column(name = "LOTE_ESTADO")
    private BigInteger loteEstado;
    @JoinColumn(name = "LOTE_TUR_ID", referencedColumnName = "TUR_ID")
    @ManyToOne(optional = false)
    private TTurno loteTurId;
    @JoinColumn(name = "LOTE_TUR_ID_END", referencedColumnName = "TUR_ID")
    @ManyToOne
    private TTurno loteTurIdEnd;
    @JoinColumn(name = "LOTE_TAG_ID", referencedColumnName = "TAG_ID")
    @ManyToOne(optional = false)
    private TTag loteTagId;
    @JoinColumn(name = "LOTE_LOC_ID", referencedColumnName = "LOC_ID")
    @ManyToOne(optional = false)
    private TLocalizacion loteLocId;

    public TLoteEnt() {
    }

    public TLoteEnt(String loteId) {
        this.loteId = loteId;
    }

    public TLoteEnt(String loteId, Date loteDate, BigInteger loteCant, BigInteger loteCantAct, BigInteger loteContador, BigInteger loteEstado) {
        this.loteId = loteId;
        this.loteDate = loteDate;
        this.loteCant = loteCant;
        this.loteCantAct = loteCantAct;
        this.loteContador = loteContador;
        this.loteEstado = loteEstado;
    }

    public String getLoteId() {
        return loteId;
    }

    public void setLoteId(String loteId) {
        this.loteId = loteId;
    }

    public String getLoteDescrip() {
        return loteDescrip;
    }

    public void setLoteDescrip(String loteDescrip) {
        this.loteDescrip = loteDescrip;
    }

    public Date getLoteDate() {
        return loteDate;
    }

    public void setLoteDate(Date loteDate) {
        this.loteDate = loteDate;
    }

    public BigInteger getLoteCant() {
        return loteCant;
    }

    public void setLoteCant(BigInteger loteCant) {
        this.loteCant = loteCant;
    }

    public BigInteger getLoteCantAct() {
        return loteCantAct;
    }

    public void setLoteCantAct(BigInteger loteCantAct) {
        this.loteCantAct = loteCantAct;
    }

    public BigInteger getLoteContador() {
        return loteContador;
    }

    public void setLoteContador(BigInteger loteContador) {
        this.loteContador = loteContador;
    }

    public BigInteger getLoteEstado() {
        return loteEstado;
    }

    public void setLoteEstado(BigInteger loteEstado) {
        this.loteEstado = loteEstado;
    }

    public Date getLoteDateEnd() {
        return loteDateEnd;
    }

    public void setLoteDateEnd(Date loteDateEnd) {
        this.loteDateEnd = loteDateEnd;
    }

   

    public TTurno getLoteTurId() {
        return loteTurId;
    }

    public void setLoteTurId(TTurno loteTurId) {
        this.loteTurId = loteTurId;
    }

    public TTurno getLoteTurIdEnd() {
        return loteTurIdEnd;
    }

    public void setLoteTurIdEnd(TTurno loteTurIdEnd) {
        this.loteTurIdEnd = loteTurIdEnd;
    }

    public TTag getLoteTagId() {
        return loteTagId;
    }

    public void setLoteTagId(TTag loteTagId) {
        this.loteTagId = loteTagId;
    }

    public TLocalizacion getLoteLocId() {
        return loteLocId;
    }

    public void setLoteLocId(TLocalizacion loteLocId) {
        this.loteLocId = loteLocId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loteId != null ? loteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteEnt)) {
            return false;
        }
        TLoteEnt other = (TLoteEnt) object;
        if ((this.loteId == null && other.loteId != null) || (this.loteId != null && !this.loteId.equals(other.loteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteEnt[ loteId=" + loteId + " ]";
    }

   
}

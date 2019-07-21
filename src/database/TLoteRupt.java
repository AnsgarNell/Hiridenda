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
@Table(name = "T_LOTE_RUPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLoteRupt.findAll", query = "SELECT t FROM TLoteRupt t"),
    @NamedQuery(name = "TLoteRupt.findByLotrId", query = "SELECT t FROM TLoteRupt t WHERE t.lotrId = :lotrId"),
    @NamedQuery(name = "TLoteRupt.findByLotrDescrip", query = "SELECT t FROM TLoteRupt t WHERE t.lotrDescrip = :lotrDescrip"),
    @NamedQuery(name = "TLoteRupt.findByLotrDate", query = "SELECT t FROM TLoteRupt t WHERE t.lotrDate = :lotrDate"),
    @NamedQuery(name = "TLoteRupt.findByLotrCant", query = "SELECT t FROM TLoteRupt t WHERE t.lotrCant = :lotrCant"),
    @NamedQuery(name = "TLoteRupt.findByLotrCantAct", query = "SELECT t FROM TLoteRupt t WHERE t.lotrCantAct = :lotrCantAct"),
    @NamedQuery(name = "TLoteRupt.findByLotrContador", query = "SELECT t FROM TLoteRupt t WHERE t.lotrContador = :lotrContador"),
    @NamedQuery(name = "TLoteRupt.findByLotrEstado", query = "SELECT t FROM TLoteRupt t WHERE t.lotrEstado = :lotrEstado"),
    @NamedQuery(name = "TLoteRupt.findByLotrDateEnd", query = "SELECT t FROM TLoteRupt t WHERE t.lotrDateEnd = :lotrDateEnd")})
public class TLoteRupt implements Serializable {
    @Basic(optional =     false)
    @Column(name = "LOTR_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lotrDate;
    @Column(name =     "LOTR_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lotrDateEnd;
   
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LOTR_ID")
    private String lotrId;
    @Column(name = "LOTR_DESCRIP")
    private String lotrDescrip;
    @Basic(optional = false)
    @Column(name = "LOTR_CANT")
    private BigInteger lotrCant;
    @Basic(optional = false)
    @Column(name = "LOTR_CANT_ACT")
    private BigInteger lotrCantAct;
    @Basic(optional = false)
    @Column(name = "LOTR_CONTADOR")
    private BigInteger lotrContador;
    @Basic(optional = false)
    @Column(name = "LOTR_ESTADO")
    private BigInteger lotrEstado;
    @JoinColumn(name = "LOTR_TUR_ID", referencedColumnName = "TUR_ID")
    @ManyToOne(optional = false)
    private TTurno lotrTurId;
    @JoinColumn(name = "LOTR_TUR_ID_END", referencedColumnName = "TUR_ID")
    @ManyToOne
    private TTurno lotrTurIdEnd;
    @JoinColumn(name = "LOTR_TAG_ID", referencedColumnName = "TAG_ID")
    @ManyToOne(optional = false)
    private TTag lotrTagId;
    @JoinColumn(name = "LOTR_LOC_ID", referencedColumnName = "LOC_ID")
    @ManyToOne(optional = false)
    private TLocalizacion lotrLocId;

    public TLoteRupt() {
    }

    public TLoteRupt(String lotrId) {
        this.lotrId = lotrId;
    }

    public TLoteRupt(String lotrId, Date lotrDate, BigInteger lotrCant, BigInteger lotrCantAct, BigInteger lotrContador, BigInteger lotrEstado) {
        this.lotrId = lotrId;
        this.lotrDate = lotrDate;
        this.lotrCant = lotrCant;
        this.lotrCantAct = lotrCantAct;
        this.lotrContador = lotrContador;
        this.lotrEstado = lotrEstado;
    }

    public String getLotrId() {
        return lotrId;
    }

    public void setLotrId(String lotrId) {
        this.lotrId = lotrId;
    }

    public String getLotrDescrip() {
        return lotrDescrip;
    }

    public void setLotrDescrip(String lotrDescrip) {
        this.lotrDescrip = lotrDescrip;
    }

    public Date getLotrDate() {
        return lotrDate;
    }

    public void setLotrDate(Date lotrDate) {
        this.lotrDate = lotrDate;
    }

    public BigInteger getLotrCant() {
        return lotrCant;
    }

    public void setLotrCant(BigInteger lotrCant) {
        this.lotrCant = lotrCant;
    }

    public BigInteger getLotrCantAct() {
        return lotrCantAct;
    }

    public void setLotrCantAct(BigInteger lotrCantAct) {
        this.lotrCantAct = lotrCantAct;
    }

    public BigInteger getLotrContador() {
        return lotrContador;
    }

    public void setLotrContador(BigInteger lotrContador) {
        this.lotrContador = lotrContador;
    }

    public BigInteger getLotrEstado() {
        return lotrEstado;
    }

    public void setLotrEstado(BigInteger lotrEstado) {
        this.lotrEstado = lotrEstado;
    }

    public Date getLotrDateEnd() {
        return lotrDateEnd;
    }

    public void setLotrDateEnd(Date lotrDateEnd) {
        this.lotrDateEnd = lotrDateEnd;
    }

  

    public TTurno getLotrTurId() {
        return lotrTurId;
    }

    public void setLotrTurId(TTurno lotrTurId) {
        this.lotrTurId = lotrTurId;
    }

    public TTurno getLotrTurIdEnd() {
        return lotrTurIdEnd;
    }

    public void setLotrTurIdEnd(TTurno lotrTurIdEnd) {
        this.lotrTurIdEnd = lotrTurIdEnd;
    }

    public TTag getLotrTagId() {
        return lotrTagId;
    }

    public void setLotrTagId(TTag lotrTagId) {
        this.lotrTagId = lotrTagId;
    }

    public TLocalizacion getLotrLocId() {
        return lotrLocId;
    }

    public void setLotrLocId(TLocalizacion lotrLocId) {
        this.lotrLocId = lotrLocId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lotrId != null ? lotrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLoteRupt)) {
            return false;
        }
        TLoteRupt other = (TLoteRupt) object;
        if ((this.lotrId == null && other.lotrId != null) || (this.lotrId != null && !this.lotrId.equals(other.lotrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TLoteRupt[ lotrId=" + lotrId + " ]";
    }

    
}

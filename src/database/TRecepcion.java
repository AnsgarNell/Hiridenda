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
@Table(name = "T_RECEPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TRecepcion.findAll", query = "SELECT t FROM TRecepcion t"),
    @NamedQuery(name = "TRecepcion.findByRecId", query = "SELECT t FROM TRecepcion t WHERE t.recId = :recId"),
    @NamedQuery(name = "TRecepcion.findByRecAlbaran", query = "SELECT t FROM TRecepcion t WHERE t.recAlbaran = :recAlbaran"),
    @NamedQuery(name = "TRecepcion.findByRecMatricula", query = "SELECT t FROM TRecepcion t WHERE t.recMatricula = :recMatricula"),
    @NamedQuery(name = "TRecepcion.findByRecDniTransp", query = "SELECT t FROM TRecepcion t WHERE t.recDniTransp = :recDniTransp"),
    @NamedQuery(name = "TRecepcion.findByRecDate", query = "SELECT t FROM TRecepcion t WHERE t.recDate = :recDate"),
    @NamedQuery(name = "TRecepcion.findByRecContador", query = "SELECT t FROM TRecepcion t WHERE t.recContador = :recContador"),
    @NamedQuery(name = "TRecepcion.findByRecEstado", query = "SELECT t FROM TRecepcion t WHERE t.recEstado = :recEstado"),
    @NamedQuery(name = "TRecepcion.findByRecDateEnd", query = "SELECT t FROM TRecepcion t WHERE t.recDateEnd = :recDateEnd")})
public class TRecepcion implements Serializable {
    @Basic(optional = false)
    @Column(name = "REC_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recDate;
    @Column(name = "REC_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recDateEnd;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "REC_ID")
    private String recId;
    @Column(name = "REC_ALBARAN")
    private String recAlbaran;
    @Column(name = "REC_MATRICULA")
    private String recMatricula;
    @Column(name = "REC_DNI_TRANSP")
    private String recDniTransp;
    @Basic(optional = false)
    @Column(name = "REC_CONTADOR")
    private BigInteger recContador;
    @Basic(optional = false)
    @Column(name = "REC_ESTADO")
    private BigInteger recEstado;
    @JoinColumn(name = "REC_TUR_ID_END", referencedColumnName = "TUR_ID")
    @ManyToOne
    private TTurno recTurIdEnd;
    @JoinColumn(name = "REC_TUR_ID", referencedColumnName = "TUR_ID")
    @ManyToOne(optional = false)
    private TTurno recTurId;
    @JoinColumn(name = "REC_LOC_ID", referencedColumnName = "LOC_ID")
    @ManyToOne(optional = false)
    private TLocalizacion recLocId;

    public TRecepcion() {
    }

    public TRecepcion(String recId) {
        this.recId = recId;
    }

    public TRecepcion(String recId, Date recDate, BigInteger recContador, BigInteger recEstado) {
        this.recId = recId;
        this.recDate = recDate;
        this.recContador = recContador;
        this.recEstado = recEstado;
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getRecAlbaran() {
        return recAlbaran;
    }

    public void setRecAlbaran(String recAlbaran) {
        this.recAlbaran = recAlbaran;
    }

    public String getRecMatricula() {
        return recMatricula;
    }

    public void setRecMatricula(String recMatricula) {
        this.recMatricula = recMatricula;
    }

    public String getRecDniTransp() {
        return recDniTransp;
    }

    public void setRecDniTransp(String recDniTransp) {
        this.recDniTransp = recDniTransp;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public BigInteger getRecContador() {
        return recContador;
    }

    public void setRecContador(BigInteger recContador) {
        this.recContador = recContador;
    }

    public BigInteger getRecEstado() {
        return recEstado;
    }

    public void setRecEstado(BigInteger recEstado) {
        this.recEstado = recEstado;
    }

    public Date getRecDateEnd() {
        return recDateEnd;
    }

    public void setRecDateEnd(Date recDateEnd) {
        this.recDateEnd = recDateEnd;
    }

   

    public TTurno getRecTurIdEnd() {
        return recTurIdEnd;
    }

    public void setRecTurIdEnd(TTurno recTurIdEnd) {
        this.recTurIdEnd = recTurIdEnd;
    }

    public TTurno getRecTurId() {
        return recTurId;
    }

    public void setRecTurId(TTurno recTurId) {
        this.recTurId = recTurId;
    }

    public TLocalizacion getRecLocId() {
        return recLocId;
    }

    public void setRecLocId(TLocalizacion recLocId) {
        this.recLocId = recLocId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recId != null ? recId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRecepcion)) {
            return false;
        }
        TRecepcion other = (TRecepcion) object;
        if ((this.recId == null && other.recId != null) || (this.recId != null && !this.recId.equals(other.recId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TRecepcion[ recId=" + recId + " ]";
    }

    
}

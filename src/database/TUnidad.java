/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "T_UNIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUnidad.findAll", query = "SELECT t FROM TUnidad t"),
    @NamedQuery(name = "TUnidad.findByUniId", query = "SELECT t FROM TUnidad t WHERE t.uniId = :uniId"),
    @NamedQuery(name = "TUnidad.findByUniDescrip", query = "SELECT t FROM TUnidad t WHERE t.uniDescrip = :uniDescrip"),
    @NamedQuery(name = "TUnidad.findByUniIdExt", query = "SELECT t FROM TUnidad t WHERE t.uniIdExt = :uniIdExt"),
    @NamedQuery(name = "TUnidad.findByUniContador", query = "SELECT t FROM TUnidad t WHERE t.uniContador = :uniContador"),
    @NamedQuery(name = "TUnidad.findByUniCant", query = "SELECT t FROM TUnidad t WHERE t.uniCant = :uniCant"),
    @NamedQuery(name = "TUnidad.findByUniCantAct", query = "SELECT t FROM TUnidad t WHERE t.uniCantAct = :uniCantAct")})
public class TUnidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UNI_ID")
    private String uniId;
    @Column(name = "UNI_DESCRIP")
    private String uniDescrip;
    @Basic(optional = false)
    @Column(name = "UNI_ID_EXT")
    private String uniIdExt;
    @Basic(optional = false)
    @Column(name = "UNI_CONTADOR")
    private BigInteger uniContador;
    @Basic(optional = false)
    @Column(name = "UNI_CANT")
    private BigInteger uniCant;
    @Basic(optional = false)
    @Column(name = "UNI_CANT_ACT")
    private BigInteger uniCantAct;
    @JoinColumn(name = "UNI_TIPO_ID", referencedColumnName = "TIP_ID")
    @ManyToOne(optional = false)
    private TTipo uniTipoId;
    @JoinColumn(name = "UNI_REC_ID", referencedColumnName = "REC_ID")
    @ManyToOne
    private TRecepcion uniRecId;

    public TUnidad() {
    }

    public TUnidad(String uniId) {
        this.uniId = uniId;
    }

    public TUnidad(String uniId, String uniIdExt, BigInteger uniContador, BigInteger uniCant, BigInteger uniCantAct) {
        this.uniId = uniId;
        this.uniIdExt = uniIdExt;
        this.uniContador = uniContador;
        this.uniCant = uniCant;
        this.uniCantAct = uniCantAct;
    }

    public String getUniId() {
        return uniId;
    }

    public void setUniId(String uniId) {
        this.uniId = uniId;
    }

    public String getUniDescrip() {
        return uniDescrip;
    }

    public void setUniDescrip(String uniDescrip) {
        this.uniDescrip = uniDescrip;
    }

    public String getUniIdExt() {
        return uniIdExt;
    }

    public void setUniIdExt(String uniIdExt) {
        this.uniIdExt = uniIdExt;
    }

    public BigInteger getUniContador() {
        return uniContador;
    }

    public void setUniContador(BigInteger uniContador) {
        this.uniContador = uniContador;
    }

    public BigInteger getUniCant() {
        return uniCant;
    }

    public void setUniCant(BigInteger uniCant) {
        this.uniCant = uniCant;
    }

    public BigInteger getUniCantAct() {
        return uniCantAct;
    }

    public void setUniCantAct(BigInteger uniCantAct) {
        this.uniCantAct = uniCantAct;
    }

    public TTipo getUniTipoId() {
        return uniTipoId;
    }

    public void setUniTipoId(TTipo uniTipoId) {
        this.uniTipoId = uniTipoId;
    }

    public TRecepcion getUniRecId() {
        return uniRecId;
    }

    public void setUniRecId(TRecepcion uniRecId) {
        this.uniRecId = uniRecId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uniId != null ? uniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUnidad)) {
            return false;
        }
        TUnidad other = (TUnidad) object;
        if ((this.uniId == null && other.uniId != null) || (this.uniId != null && !this.uniId.equals(other.uniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TUnidad[ uniId=" + uniId + " ]";
    } 
    
}

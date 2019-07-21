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
@Table(name = "T_TAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTag.findAll", query = "SELECT t FROM TTag t"),
    @NamedQuery(name = "TTag.findByTagId", query = "SELECT t FROM TTag t WHERE t.tagId = :tagId"),
    @NamedQuery(name = "TTag.findByTagDescrip", query = "SELECT t FROM TTag t WHERE t.tagDescrip = :tagDescrip"),
    @NamedQuery(name = "TTag.findByTagEstado", query = "SELECT t FROM TTag t WHERE t.tagEstado = :tagEstado"),
    @NamedQuery(name = "TTag.findByTagDateEnd", query = "SELECT t FROM TTag t WHERE t.tagDateEnd = :tagDateEnd")})
public class TTag implements Serializable {
    @Column(name =     "TAG_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tagDateEnd;
   
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TAG_ID")
    private String tagId;
    @Column(name = "TAG_DESCRIP")
    private String tagDescrip;
    @Basic(optional = false)
    @Column(name = "TAG_ESTADO")
    private BigInteger tagEstado;

    public TTag() {
    }

    public TTag(String tagId) {
        this.tagId = tagId;
    }

    public TTag(String tagId, BigInteger tagEstado) {
        this.tagId = tagId;
        this.tagEstado = tagEstado;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagDescrip() {
        return tagDescrip;
    }

    public void setTagDescrip(String tagDescrip) {
        this.tagDescrip = tagDescrip;
    }

    public BigInteger getTagEstado() {
        return tagEstado;
    }

    public void setTagEstado(BigInteger tagEstado) {
        this.tagEstado = tagEstado;
    }

    public Date getTagDateEnd() {
        return tagDateEnd;
    }

    public void setTagDateEnd(Date tagDateEnd) {
        this.tagDateEnd = tagDateEnd;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagId != null ? tagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTag)) {
            return false;
        }
        TTag other = (TTag) object;
        if ((this.tagId == null && other.tagId != null) || (this.tagId != null && !this.tagId.equals(other.tagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TTag[ tagId=" + tagId + " ]";
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Man Pham
 */
@Entity
@Table(name = "SINHVIEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sinhvien.findAll", query = "SELECT s FROM Sinhvien s"),
    @NamedQuery(name = "Sinhvien.findByMssv", query = "SELECT s FROM Sinhvien s WHERE s.mssv = :mssv"),
    @NamedQuery(name = "Sinhvien.findByTensv", query = "SELECT s FROM Sinhvien s WHERE s.tensv = :tensv"),
    @NamedQuery(name = "Sinhvien.findBySodt", query = "SELECT s FROM Sinhvien s WHERE s.sodt = :sodt"),
    @NamedQuery(name = "Sinhvien.findByNienkhoa", query = "SELECT s FROM Sinhvien s WHERE s.nienkhoa = :nienkhoa"),
    @NamedQuery(name = "Sinhvien.findByPassw", query = "SELECT s FROM Sinhvien s WHERE s.passw = :passw")})
public class Sinhvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MSSV")
    private String mssv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TENSV")
    private String tensv;
    @Size(max = 10)
    @Column(name = "SODT")
    private String sodt;
    @Size(max = 10)
    @Column(name = "NIENKHOA")
    private String nienkhoa;
    @Size(max = 30)
    @Column(name = "PASSW")
    private String passw;
    
    @Size(max = 30)
    @Column(name = "MACHUYENNGANH")
    private String maCN;
//    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhvien")
//    private Collection<SinhvienMonhoc> sinhvienMonhocCollection;
//    @JoinColumn(name = "MACHUYENNGANH", referencedColumnName = "MACHUYENNGANH")
//    @ManyToOne
//    private Chuyennganh machuyennganh;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhvien")
//    private Collection<Ketquathi> ketquathiCollection;

    public Sinhvien() {
    }

    public Sinhvien(String mssv) {
        this.mssv = mssv;
    }

    public Sinhvien(String mssv, String tensv) {
        this.mssv = mssv;
        this.tensv = tensv;
    }
    

    public Sinhvien(String mssv, String tensv, String sodt, String nienkhoa, String passw, String maCN ) {
        this.mssv = mssv;
        this.tensv = tensv;
        this.sodt = sodt;
        this.nienkhoa = nienkhoa;
        this.passw = passw;
        this.maCN = maCN;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getNienkhoa() {
        return nienkhoa;
    }

    public void setNienkhoa(String nienkhoa) {
        this.nienkhoa = nienkhoa;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
    
        public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

//    @XmlTransient
//    public Collection<SinhvienMonhoc> getSinhvienMonhocCollection() {
//        return sinhvienMonhocCollection;
//    }
//
//    public void setSinhvienMonhocCollection(Collection<SinhvienMonhoc> sinhvienMonhocCollection) {
//        this.sinhvienMonhocCollection = sinhvienMonhocCollection;
//    }
//
//    public Chuyennganh getMachuyennganh() {
//        return machuyennganh;
//    }
//
//    public void setMachuyennganh(Chuyennganh machuyennganh) {
//        this.machuyennganh = machuyennganh;
//    }
//
//    @XmlTransient
//    public Collection<Ketquathi> getKetquathiCollection() {
//        return ketquathiCollection;
//    }
//
//    public void setKetquathiCollection(Collection<Ketquathi> ketquathiCollection) {
//        this.ketquathiCollection = ketquathiCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mssv != null ? mssv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinhvien)) {
            return false;
        }
        Sinhvien other = (Sinhvien) object;
        if ((this.mssv == null && other.mssv != null) || (this.mssv != null && !this.mssv.equals(other.mssv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBCDR.Sinhvien[ mssv=" + mssv + " ]";
    }
    
}

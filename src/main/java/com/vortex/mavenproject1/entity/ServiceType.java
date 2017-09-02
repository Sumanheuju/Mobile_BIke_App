/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author sumanheuju
 */
@Entity
@Table(name = "tbl_service_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceType.findAll", query = "SELECT s FROM ServiceType s")
    , @NamedQuery(name = "ServiceType.findByServiceTypeId", query = "SELECT s FROM ServiceType s WHERE s.serviceTypeId = :serviceTypeId")
    , @NamedQuery(name = "ServiceType.findByServiceType", query = "SELECT s FROM ServiceType s WHERE s.serviceType = :serviceType")
    , @NamedQuery(name = "ServiceType.findByPrice", query = "SELECT s FROM ServiceType s WHERE s.price = :price")})
public class ServiceType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_type_id")
    private Integer serviceTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "service_type")
    private String serviceType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceTypeId")
    private List<Service> serviceList;

    public ServiceType() {
    }

    public ServiceType(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public ServiceType(Integer serviceTypeId, String serviceType, double price) {
        this.serviceTypeId = serviceTypeId;
        this.serviceType = serviceType;
        this.price = price;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlTransient
    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceTypeId != null ? serviceTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceType)) {
            return false;
        }
        ServiceType other = (ServiceType) object;
        if ((this.serviceTypeId == null && other.serviceTypeId != null) || (this.serviceTypeId != null && !this.serviceTypeId.equals(other.serviceTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vortex.mavenproject1.entity.ServiceType[ serviceTypeId=" + serviceTypeId + " ]";
    }
    
}

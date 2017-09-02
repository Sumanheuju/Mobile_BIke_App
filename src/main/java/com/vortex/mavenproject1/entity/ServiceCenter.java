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
@Table(name = "tbl_service_centers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceCenter.findAll", query = "SELECT s FROM ServiceCenter s")
    , @NamedQuery(name = "ServiceCenter.findByServiceCenterLocationId", query = "SELECT s FROM ServiceCenter s WHERE s.serviceCenterLocationId = :serviceCenterLocationId")
    , @NamedQuery(name = "ServiceCenter.findByServiceCenterName", query = "SELECT s FROM ServiceCenter s WHERE s.serviceCenterName = :serviceCenterName")
    , @NamedQuery(name = "ServiceCenter.findByServiceCenterArea", query = "SELECT s FROM ServiceCenter s WHERE s.serviceCenterArea = :serviceCenterArea")
    , @NamedQuery(name = "ServiceCenter.findByServiceCenterAddress", query = "SELECT s FROM ServiceCenter s WHERE s.serviceCenterAddress = :serviceCenterAddress")
    , @NamedQuery(name = "ServiceCenter.findByPhoneNo", query = "SELECT s FROM ServiceCenter s WHERE s.phoneNo = :phoneNo")
    , @NamedQuery(name = "ServiceCenter.findByEmail", query = "SELECT s FROM ServiceCenter s WHERE s.email = :email")})
public class ServiceCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_center_location_id")
    private Integer serviceCenterLocationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "service_center_name")
    private String serviceCenterName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "service_center_area")
    private String serviceCenterArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "service_center_address")
    private String serviceCenterAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "phone_no")
    private String phoneNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceCenterLocationId")
    private List<Service> serviceList;

    public ServiceCenter() {
    }

    public ServiceCenter(Integer serviceCenterLocationId) {
        this.serviceCenterLocationId = serviceCenterLocationId;
    }

    public ServiceCenter(Integer serviceCenterLocationId, String serviceCenterName, String serviceCenterArea, String serviceCenterAddress, String phoneNo, String email) {
        this.serviceCenterLocationId = serviceCenterLocationId;
        this.serviceCenterName = serviceCenterName;
        this.serviceCenterArea = serviceCenterArea;
        this.serviceCenterAddress = serviceCenterAddress;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public Integer getServiceCenterLocationId() {
        return serviceCenterLocationId;
    }

    public void setServiceCenterLocationId(Integer serviceCenterLocationId) {
        this.serviceCenterLocationId = serviceCenterLocationId;
    }

    public String getServiceCenterName() {
        return serviceCenterName;
    }

    public void setServiceCenterName(String serviceCenterName) {
        this.serviceCenterName = serviceCenterName;
    }

    public String getServiceCenterArea() {
        return serviceCenterArea;
    }

    public void setServiceCenterArea(String serviceCenterArea) {
        this.serviceCenterArea = serviceCenterArea;
    }

    public String getServiceCenterAddress() {
        return serviceCenterAddress;
    }

    public void setServiceCenterAddress(String serviceCenterAddress) {
        this.serviceCenterAddress = serviceCenterAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (serviceCenterLocationId != null ? serviceCenterLocationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceCenter)) {
            return false;
        }
        ServiceCenter other = (ServiceCenter) object;
        if ((this.serviceCenterLocationId == null && other.serviceCenterLocationId != null) || (this.serviceCenterLocationId != null && !this.serviceCenterLocationId.equals(other.serviceCenterLocationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vortex.mavenproject1.entity.ServiceCenter[ serviceCenterLocationId=" + serviceCenterLocationId + " ]";
    }
    
}

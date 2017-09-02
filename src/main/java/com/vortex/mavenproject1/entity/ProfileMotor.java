/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sumanheuju
 */
@Entity
@Table(name = "tbl_profile_motors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfileMotor.findAll", query = "SELECT p FROM ProfileMotor p")
    , @NamedQuery(name = "ProfileMotor.findByProfileMotorId", query = "SELECT p FROM ProfileMotor p WHERE p.profileMotorId = :profileMotorId")
    , @NamedQuery(name = "ProfileMotor.findByCompanyName", query = "SELECT p FROM ProfileMotor p WHERE p.companyName = :companyName")
    , @NamedQuery(name = "ProfileMotor.findByMotorName", query = "SELECT p FROM ProfileMotor p WHERE p.motorName = :motorName")
    , @NamedQuery(name = "ProfileMotor.findByEngineNumber", query = "SELECT p FROM ProfileMotor p WHERE p.engineNumber = :engineNumber")
    , @NamedQuery(name = "ProfileMotor.findByMotorRegistrationDate", query = "SELECT p FROM ProfileMotor p WHERE p.motorRegistrationDate = :motorRegistrationDate")
    , @NamedQuery(name = "ProfileMotor.findByMotorColor", query = "SELECT p FROM ProfileMotor p WHERE p.motorColor = :motorColor")
    , @NamedQuery(name = "ProfileMotor.findByChassisNumber", query = "SELECT p FROM ProfileMotor p WHERE p.chassisNumber = :chassisNumber")
    , @NamedQuery(name = "ProfileMotor.findByMotorPicture", query = "SELECT p FROM ProfileMotor p WHERE p.motorPicture = :motorPicture")})
public class ProfileMotor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "profile_motor_id")
    private Integer profileMotorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "company_name")
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "motor_name")
    private String motorName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "engine_number")
    private String engineNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "motor_registration_date")
    @Temporal(TemporalType.DATE)
    private Date motorRegistrationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "motor_color")
    private String motorColor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "chassis_number")
    private String chassisNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "motor_picture")
    private String motorPicture;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileMotorId")
    private List<Profile> profileList;

    public ProfileMotor() {
    }

    public ProfileMotor(Integer profileMotorId) {
        this.profileMotorId = profileMotorId;
    }

    public ProfileMotor(Integer profileMotorId, String companyName, String motorName, String engineNumber, Date motorRegistrationDate, String motorColor, String chassisNumber, String motorPicture) {
        this.profileMotorId = profileMotorId;
        this.companyName = companyName;
        this.motorName = motorName;
        this.engineNumber = engineNumber;
        this.motorRegistrationDate = motorRegistrationDate;
        this.motorColor = motorColor;
        this.chassisNumber = chassisNumber;
        this.motorPicture = motorPicture;
    }

    public Integer getProfileMotorId() {
        return profileMotorId;
    }

    public void setProfileMotorId(Integer profileMotorId) {
        this.profileMotorId = profileMotorId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMotorName() {
        return motorName;
    }

    public void setMotorName(String motorName) {
        this.motorName = motorName;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public Date getMotorRegistrationDate() {
        return motorRegistrationDate;
    }

    public void setMotorRegistrationDate(Date motorRegistrationDate) {
        this.motorRegistrationDate = motorRegistrationDate;
    }

    public String getMotorColor() {
        return motorColor;
    }

    public void setMotorColor(String motorColor) {
        this.motorColor = motorColor;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getMotorPicture() {
        return motorPicture;
    }

    public void setMotorPicture(String motorPicture) {
        this.motorPicture = motorPicture;
    }

    @XmlTransient
    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileMotorId != null ? profileMotorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfileMotor)) {
            return false;
        }
        ProfileMotor other = (ProfileMotor) object;
        if ((this.profileMotorId == null && other.profileMotorId != null) || (this.profileMotorId != null && !this.profileMotorId.equals(other.profileMotorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vortex.mavenproject1.entity.ProfileMotor[ profileMotorId=" + profileMotorId + " ]";
    }
    
}

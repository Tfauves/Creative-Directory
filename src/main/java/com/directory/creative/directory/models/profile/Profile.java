package com.directory.creative.directory.models.profile;

import com.directory.creative.directory.models.media.Media;
import com.directory.creative.directory.models.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "profile")
// @SQLDelete annotation to override the delete command.
// changes the deleted field value to true instead of deleting the data permanently.
@SQLDelete(sql = "UPDATE profile SET deleted = true WHERE id =?")
//the deleted data will still be accessible.

//@FilterDef annotation defines the basic requirements that will be used by @Filter annotation
@FilterDef(name = "deletedProfileFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedProfileFilter", condition = "deleted = :isDeleted")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String businessName;
    private String homeAddress;
    private String phone;
    private String businessPhone;
    private String website;
    private String email;
    private String social;
    
    //deleted property with the default value set as FALSE
    private Boolean deleted = Boolean.FALSE;

    @OneToOne
    @JsonIgnoreProperties("id")
    private ProfileImg proImg;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToOne
    @JoinColumn(name = "media_id", referencedColumnName = "id")
    private Media media;

    public Profile() {}

    public Profile(String fname, String lname, String businessName, String homeAddress, String phone, String businessPhone, String website, String email, String social, Boolean deleted, ProfileImg proImg, User user, Media media) {
        this.fname = fname;
        this.lname = lname;
        this.businessName = businessName;
        this.homeAddress = homeAddress;
        this.phone = phone;
        this.businessPhone = businessPhone;
        this.website = website;
        this.email = email;
        this.social = social;
        this.deleted = deleted;
        this.proImg = proImg;
        this.user = user;
        this.media = media;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public ProfileImg getProImg() {
        return proImg;
    }

    public void setProImg(ProfileImg proImg) {
        this.proImg = proImg;
    }
}

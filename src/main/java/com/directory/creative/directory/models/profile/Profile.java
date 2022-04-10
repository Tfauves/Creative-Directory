package com.directory.creative.directory.models.profile;

import com.directory.creative.directory.models.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String city;
    private String state;
    private String phone;
    private String discipline;
    //deleted property with the default value set as FALSE
    private Boolean deleted = Boolean.FALSE;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    public Profile() {}

    public Profile(User user, String fname, String lname, String phone, String discipline, String city) {
        this.user = user;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.discipline = discipline;
        this.city = city;
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

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}

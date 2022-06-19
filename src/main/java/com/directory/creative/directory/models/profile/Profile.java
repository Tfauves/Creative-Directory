package com.directory.creative.directory.models.profile;

import com.directory.creative.directory.models.contact.Contact;
import com.directory.creative.directory.models.media.Media;
import com.directory.creative.directory.models.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
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
    private String name;
    //deleted property with the default value set as FALSE
    private Boolean deleted = Boolean.FALSE;

    @OneToOne
    @JsonIgnoreProperties("id")
    private ProfileImg proImg;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_info", referencedColumnName = "id")
    private Contact contact;

    @OneToOne
    private Media media;

    public Profile() {}

    public Profile(User user, ProfileImg proImg, String name, Contact contact) {
        this.user = user;
        this.name = name;
        this.contact = contact;
        this.proImg = proImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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

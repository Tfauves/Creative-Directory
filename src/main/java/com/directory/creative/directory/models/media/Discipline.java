package com.directory.creative.directory.models.media;

import com.directory.creative.directory.models.profile.Profile;
import javax.persistence.*;

@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String practice;

    public Discipline() {}


    public Discipline(String practice) {
        this.practice = practice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }
}

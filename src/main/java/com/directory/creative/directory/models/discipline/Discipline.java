package com.directory.creative.directory.models.discipline;

import javax.persistence.*;

@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String practice;
    @OneToOne
    @JoinColumn(name = "media_type_id", referencedColumnName = "id")
    private MediaType mediaType;

    public Discipline() {}

    public Discipline(String practice, MediaType mediaType) {
        this.practice = practice;
        this.mediaType = mediaType;
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


    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}

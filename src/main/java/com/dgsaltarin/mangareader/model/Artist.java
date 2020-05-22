package com.dgsaltarin.mangareader.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "artist")
public class Artist {
    private int idArtist;
    private String name;
    private List<Manga> mangas;

    public Artist() {
    }

    public Artist(String name, List<Manga> mangas) {
        this.name = name;
        this.mangas = mangas;
    }

    @Id
    @Column(name = "id_artist")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }
}

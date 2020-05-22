package com.dgsaltarin.mangareader.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tag")
public class Tag {
    private int idTag;
    private String name;
    private List<Manga> mangas;

    @Id
    @Column(name = "id_tag")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnore
    public List<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }
}

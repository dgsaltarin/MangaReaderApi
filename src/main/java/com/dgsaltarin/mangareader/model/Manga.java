package com.dgsaltarin.mangareader.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manga")
public class Manga {
    private int idManga;
    private String name;
    private String description;
    private Integer chapters;
    private Byte status;
    private String cover;
    private List<Chapter> chaptersList;
    private Artist artist;
    private List<Tag> tags;

    public Manga() {
    }

    public Manga(int idManga, String name, String description, Integer chapters, Byte status, String cover) {
        this.idManga = idManga;
        this.name = name;
        this.description = description;
        this.chapters = chapters;
        this.status = status;
        this.cover = cover;
        this.tags = tags;
    }

    @Id
    @Column(name = "id_manga")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdManga() {
        return idManga;
    }

    public void setIdManga(int idManga) {
        this.idManga = idManga;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "chapters")
    public Integer getChapters() {
        return chapters;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "cover")
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Chapter> getChaptersList() {
        return chaptersList;
    }

    public void setChaptersList(List<Chapter> chaptersList) {
        this.chaptersList = chaptersList;
    }

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artist")
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinTable(name = "manga_tag", joinColumns = @JoinColumn(name = "id_manga"),
    inverseJoinColumns = @JoinColumn(name = "id_tag"))
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}

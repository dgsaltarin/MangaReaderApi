package com.dgsaltarin.mangareader.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chapter")
public class Chapter {
    private int idChapter;
    private Integer pages;
    private Manga manga;

    @Id
    @Column(name = "id_chapter")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdChapter() {
        return idChapter;
    }

    public void setIdChapter(int idChapter) {
        this.idChapter = idChapter;
    }

    @Basic
    @Column(name = "pages")
    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_manga")
    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }
}

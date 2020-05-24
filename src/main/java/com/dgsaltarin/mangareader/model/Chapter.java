package com.dgsaltarin.mangareader.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "chapter")
public class Chapter {
    private int idChapter;
    private Integer pages;
    private Timestamp date;
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

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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

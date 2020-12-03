package com.dgsaltarin.mangareader.dao.impl;

import com.dgsaltarin.mangareader.dao.AbstractSession;
import com.dgsaltarin.mangareader.dao.TagDao;
import com.dgsaltarin.mangareader.model.Manga;
import com.dgsaltarin.mangareader.model.Tag;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TagDaoImplement extends AbstractSession implements TagDao {

    /**
     * get all tags from the data base
     * @return all list of tag objects
     */
    @Override
    public List<Tag> getAllTags() {
        return getSession().createQuery("from Tag").list();
    }

    /**
     * get all mangas by a tag's id
     * @param idTag id from the tag
     * @return a list of mangas
     */
    @Override
    public List<Manga> getAllMangasByTag(int idTag) {
        return null;
    }

    /**
     * get a tag object by an id
     * @param idTag tag's id
     * @return a tag
     */
    @Override
    public Tag getTagById(int idTag) {
        return getSession().get(Tag.class, idTag);
    }

    /**
     * get a tag object by his name
     * @param name from the tag
     * @return a tag
     */
    @Override
    public Tag getTagByName(String name) {
        return (Tag) getSession().createQuery("from Tag where name = :name")
                .setParameter("name", name).uniqueResult();
    }
}

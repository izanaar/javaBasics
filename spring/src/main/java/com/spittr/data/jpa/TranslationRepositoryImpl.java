package com.spittr.data.jpa;

import com.spittr.data.entities.Translation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class TranslationRepositoryImpl implements TranslationsToEng{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Translation> findTranslationsToEnglish() {
        String query = "select t from Translation t where t.finalLanguage = 'en'";
        return em.createQuery(query).getResultList();
    }

}

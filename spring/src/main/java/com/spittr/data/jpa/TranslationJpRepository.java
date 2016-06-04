package com.spittr.data.jpa;

import com.spittr.data.entities.Translation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class TranslationJpRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveTranslation(Translation translation){
        entityManager.persist(translation);
    }

    public Translation find(Long id){
        return entityManager.find(Translation.class, id);
    }

}

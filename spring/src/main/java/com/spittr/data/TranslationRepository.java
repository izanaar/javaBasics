package com.spittr.data;


import com.spittr.data.entities.Translation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TranslationRepository {

    @PersistenceContext
    private EntityManager em;

    public void saveTranslation(Translation translation){
        em.persist(translation);
    }

    public void saveTranslationList(List<Translation> translationList){
        em.persist(translationList);
    }

    public List<Translation> getTranslationList(){
        return em.createQuery("from Translation").getResultList();
    }
}

package com.spittr.data.jpa;

import com.spittr.data.entities.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<Translation, Long>, TranslationsToEng{
}

package com.spittr.data;

import com.spittr.config.RootConfig;
import com.spittr.data.entities.Translation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = RootConfig.class)
public class JpaTest {

    @Autowired
    private TranslationRepository translationRepository;

    @Test
    public void testPersistTranslation() throws Exception {
 /*       Translation translation = new Translation("Tempest keep", "en","ru");
        translationRepository.saveTranslation(translation);*/

        translationRepository.saveTranslationSet(loadTranslations());

        int k = 2;
    }

    private Set<com.spittr.data.entities.Translation> loadTranslations() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/traum/Documents/Dropbox/translations.bin"))){
            Set<com.izanaar.model.Translation> translations = (Set<com.izanaar.model.Translation>) ois.readObject();

            Set<com.spittr.data.entities.Translation> newTranslations = translations.stream()
                    .map(oldTranslation -> new com.spittr.data.entities.Translation(
                            oldTranslation.getInputText(), oldTranslation.getInputLanguage(), oldTranslation.getFinalLanguage()
                    )).collect(Collectors.toSet());
            return newTranslations;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

}

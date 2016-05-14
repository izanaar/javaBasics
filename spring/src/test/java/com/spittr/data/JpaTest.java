package com.spittr.data;

import com.spittr.config.RootConfig;
import com.spittr.data.entities.Translation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = RootConfig.class)
public class JpaTest {

    @Autowired
    private TranslationRepository translationRepository;

    @Test
    public void testPersistTranslation() throws Exception {
        Translation translation = new Translation("Tempest keep", "en","ru");
        translationRepository.saveTranslation(translation);

        List<Translation> translationList = translationRepository.getTranslationList();
        int k = 2;
    }
}

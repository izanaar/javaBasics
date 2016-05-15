package com.spittr.data;

import com.spittr.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = RootConfig.class)
public class JpaTest {

    @Autowired
    private TranslationRepository translationRepository;

    @Test
    public void testPersistTranslation() throws Exception {

        translationRepository.getTranslationList().forEach(System.out::println);

    }

}

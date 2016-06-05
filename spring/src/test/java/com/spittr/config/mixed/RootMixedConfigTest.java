package com.spittr.config.mixed;

import com.spittr.pojo.SimpleBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootMixedConfig.class)
public class RootMixedConfigTest {

    @Autowired
    private List<SimpleBean> beans;

    @Test
    public void firstBeanInitialized() throws Exception {
        assertNotNull(beans);
        assertEquals(3, beans.size());
        beans.forEach(System.out::println);
    }
}
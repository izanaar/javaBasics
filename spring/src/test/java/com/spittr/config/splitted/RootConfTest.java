package com.spittr.config.splitted;

import com.spittr.model.SimpleBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConf.class)
public class RootConfTest {

    @Autowired
    private List<SimpleBean> simpleBeanList;

    @Test
    public void testSplittedConf() throws Exception {
        assertNotNull(simpleBeanList);
        assertEquals(2,simpleBeanList.size());
        simpleBeanList.forEach(System.out::println);

    }
}
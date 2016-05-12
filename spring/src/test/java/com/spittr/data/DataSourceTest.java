package com.spittr.data;

import com.spittr.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = RootConfig.class)
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void name() throws Exception {

        String query = "SELECT * FROM users WHERE username=?";

        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, "user");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(2));
        }
    }
}

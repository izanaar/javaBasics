package com.spittr.data;

import com.spittr.config.RootConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = RootConfig.class)
public class DataSourceTest {


    private RowMapper<Message> userRowMapper = (resultSet, i) -> new Message(resultSet.getLong(1), resultSet.getString(2));

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    @Ignore
    public void testGetByJdbc() throws Exception {

        String query = "SELECT * FROM users WHERE username=?";

        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, "user");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(2));
        }
    }

    @Test
    @Ignore
    public void testGetByJdbcTemplate() throws Exception {
        String sql = "SELECT * FROM messages where id=?";
        System.out.println(jdbcOperations.queryForObject(sql, userRowMapper, 1));
    }

    @Test
    @Ignore
    public void testGetByNamedJdbcTemplate() throws Exception {
        String sql = "SELECT * FROM messages where id=:id";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", 1);

        System.out.println(namedParameterJdbcTemplate.queryForObject(sql,paramMap, userRowMapper));
    }

    class Message {
        public long id;
        public String message;

        public Message(long id, String message) {
            this.id = id;
            this.message = message;
        }

        @Override
        public String toString() {
            return "id: "+ id + "; message: " + message;
        }
    }
}

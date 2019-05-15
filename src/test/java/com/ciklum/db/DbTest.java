package com.ciklum.db;

import com.ciklum.config.SpringConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class DbTest {

    @Autowired
    Connection connection;

    /*
    1. Select author name for book "Hibernate"
    2. Check results
     */
    @Test
    public void testDatabase() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT a.name as author_name " +
                "FROM author a, book b, author_book ab " +
                "WHERE ab.author_id = a.id AND ab.book_id = b.id AND b.name = ?");
        statement.setString(1, "Hibernate");
        ResultSet resultSet = statement.executeQuery();
        List authors = new ArrayList<String>();
        while (resultSet.next()) {
            authors.add(resultSet.getString("author_name"));
        }
        Assertions.assertIterableEquals(Arrays.asList("Nata", "Dmitry"), authors);
    }
}

package com.ciklum.db;

import com.ciklum.config.SpringConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class DbTest {

    @Autowired
    Connection connection;

    /*
    1. Select author name for book "Hibernate"
    2. Check results
     */
}

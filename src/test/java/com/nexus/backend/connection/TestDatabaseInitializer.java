package com.nexus.backend.connection;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class TestDatabaseInitializer {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("sql/dataClient.sql"));
            System.out.println("Database initialized");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
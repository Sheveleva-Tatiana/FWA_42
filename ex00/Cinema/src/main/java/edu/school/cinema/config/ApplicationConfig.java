package edu.school.cinema.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
@ComponentScan("edu.school.cinema")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    @Value("${db_url}")
    private String url;
    @Value("${db_user}")
    private String user;
    @Value("${db_pass}")
    private String password;
    @Value("${driver}")
    private String driver;
    @Value("${schema}")
    private String schema;

    @Bean
    public HikariDataSource dataSource() throws SQLException, IOException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);
        Statement st = dataSource.getConnection().createStatement();
        st.execute(new String(Files.readAllBytes(Paths.get(schema))));
        return dataSource;
    }

    @Bean
    public PasswordEncoder encoderPass() {
        return new BCryptPasswordEncoder();
    }

}

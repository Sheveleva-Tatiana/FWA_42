package edu.school.cinema.repositories;

import edu.school.cinema.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl implements UsersRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User entity) {
        String inQuery = "INSERT INTO cinema.user (name, surname, phoneNumber, password) VALUES (?, ?, ?, ?)";
        int i = jdbcTemplate.update(inQuery, entity.getName(), entity.getPassword(), entity.getPhoneNumber(), entity.getPassword());

        if (i == 0) {
            System.err.println("User wasn't saved: " + entity);
        }
    }

    @Override
    public void update(User entity) {
        String upQuery = "UPDATE cinema.user SET name = ?, surname = ?, phoneNumber = ?, password = ? WHERE id = ?";
        int i = jdbcTemplate.update(upQuery, entity.getName(),
                entity.getPassword(), entity.getPhoneNumber(), entity.getPassword(), entity.getId());

        if (i == 0) {
            System.err.println("User wasn't updated: " + entity);
        }
    }

    @Override
    public void delete(Long id) {
        String dlQuery = "DELETE FROM cinema.user WHERE id = ?";
        int i = jdbcTemplate.update(dlQuery, id);

        if (i == 0) {
            System.err.println("User not found with id: " + id);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        String usQuery = "SELECT * FROM cinema.user WHERE name = ?";
        User user = jdbcTemplate.query(usQuery,
                new Object[]{username},
                new int[]{Types.VARCHAR},
                new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
        return Optional.ofNullable(user);
    }
}

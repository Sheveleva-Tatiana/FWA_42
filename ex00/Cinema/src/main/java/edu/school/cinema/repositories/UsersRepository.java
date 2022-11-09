package edu.school.cinema.repositories;

import edu.school.cinema.model.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findByUsername(String username);
}

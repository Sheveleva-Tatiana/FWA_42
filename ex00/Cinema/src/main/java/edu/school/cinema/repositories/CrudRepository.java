package edu.school.cinema.repositories;

public interface CrudRepository<T> {
    void save(T entity);
    void update(T entity);
    void delete(Long id);
}


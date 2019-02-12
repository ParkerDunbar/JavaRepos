package library.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import library.model.Book;

public interface BookJpaRepository extends JpaRepository<Book, Integer> {

}

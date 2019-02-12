package shoppinglist.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import shoppinglist.model.Item;

public interface ItemJpaRepository extends JpaRepository<Item, Integer> {

}

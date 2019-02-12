package shoppinglist.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import shoppinglist.model.ShoppingList;

public interface SLJpaRepository extends JpaRepository<ShoppingList, Integer> {

}

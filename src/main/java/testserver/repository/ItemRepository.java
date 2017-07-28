package testserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import testserver.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}

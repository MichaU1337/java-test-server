package testserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import testserver.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

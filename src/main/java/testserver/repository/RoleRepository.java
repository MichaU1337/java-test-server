package testserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import testserver.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}

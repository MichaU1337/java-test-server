package testserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import testserver.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

}

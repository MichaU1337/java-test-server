package testserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import testserver.entity.Blog;
import testserver.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog> findByUser(User user);
	
}

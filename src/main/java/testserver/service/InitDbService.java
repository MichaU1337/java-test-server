package testserver.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testserver.entity.Blog;
import testserver.entity.Item;
import testserver.entity.Role;
import testserver.entity.User;
import testserver.repository.BlogRepository;
import testserver.repository.ItemRepository;
import testserver.repository.RoleRepository;
import testserver.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");			
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogTestServer = new Blog();
		blogTestServer.setName("TestServer");
		blogTestServer.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogTestServer.setUser(userAdmin);
		blogRepository.save(blogTestServer);
		
		Item item1 = new Item();
		item1.setBlog(blogTestServer);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogTestServer);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
		
	}
}

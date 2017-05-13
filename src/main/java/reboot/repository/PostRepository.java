package reboot.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import reboot.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByName(String name);
	
	Post findById(Long id);
		
}

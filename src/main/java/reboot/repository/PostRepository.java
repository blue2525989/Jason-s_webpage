package reboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import reboot.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	Post findByName(String name);
	
	Post findById(Long id);
			
}

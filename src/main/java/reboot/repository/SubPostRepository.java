package reboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import reboot.model.PostSub;

public interface SubPostRepository extends JpaRepository<PostSub, Long> {

	PostSub findById(Long id);
	
		
}

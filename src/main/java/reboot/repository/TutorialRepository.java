package reboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import reboot.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	List<Tutorial> findByName(String name);

	Tutorial findById(Long id);
		
}


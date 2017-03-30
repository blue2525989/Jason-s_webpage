package reboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import reboot.model.Guest;

public interface GuestbookRepository extends JpaRepository<Guest, Long> {

	List<Guest> findByName(String name);

	List<Guest> findById(Long count);
		
}


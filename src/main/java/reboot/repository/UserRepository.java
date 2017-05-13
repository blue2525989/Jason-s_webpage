package reboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import reboot.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String username);

	List<Users> findById(Long count);
		
}


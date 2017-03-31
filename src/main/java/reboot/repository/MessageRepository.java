package reboot.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import reboot.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findByName(String name);
		
}

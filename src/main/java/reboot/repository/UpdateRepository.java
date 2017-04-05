package reboot.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import reboot.model.UpdateMessages;

public interface UpdateRepository extends JpaRepository<UpdateMessages, Long> {

	List<UpdateMessages> findById(Long id);
		
}

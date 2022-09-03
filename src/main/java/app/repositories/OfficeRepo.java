package app.repositories;

import app.models.Officer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficeRepo extends CrudRepository<Officer, Long> {

    Officer findAllByUsername(String username);

}

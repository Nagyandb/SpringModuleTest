package app.repositories;

import app.models.Crew;
import app.models.SpaceShip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface CrewRepo extends CrudRepository<Crew, Long> {

    List<Crew> findCrewBy();
}

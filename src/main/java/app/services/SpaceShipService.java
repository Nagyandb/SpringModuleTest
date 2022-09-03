package app.services;

import app.models.Crew;
import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpaceShipService {

    private final SpaceShipRepo spaceShipRepo;

    @Autowired
    public SpaceShipService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }



    /*public List<Crew> getAllCrewDates(Long id) {
        List<Crew> getCrew = new ArrayList<>();
        Optional<SpaceShip> ship = spaceShipRepo.findById(id);
        getCrew.addAll(ship.get().getCrews());
        return getCrew;
    }*/
}

package app.services;

import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceShipService {

    private SpaceShipRepo spaceShipRepo;

    @Autowired
    public SpaceShipService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<SpaceShip> allSpaceShips(){
        return (List<SpaceShip>) spaceShipRepo.findAll();
    }

    /*public List<SpaceShip> spaceShipList() {
        List<SpaceShip> result = new ArrayList<>();
        for (SpaceShip ship : spaceShipList()) {
            if(ship.isActive()){
                result.add(ship);
            }
        }
        return result;
    }*/
}

package app.controllers;

import app.models.Crew;
import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.repositories.CrewRepo;
import app.repositories.SpaceShipRepo;
import app.services.SpaceShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SpaceShipController {

    private final SpaceShipService spaceShipService;
    private SpaceShipRepo spaceShipRepo;

    private CrewRepo crewRepo;

    public SpaceShipController(SpaceShipService spaceShipService) {
        this.spaceShipService = spaceShipService;
    }

    @Autowired
    public SpaceShipController(SpaceShipService spaceShipService, SpaceShipRepo spaceShipRepo) {
        this.spaceShipService = spaceShipService;
        this.spaceShipRepo = spaceShipRepo;
    }

    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }

    @GetMapping (value = {"/allspaceships"})
    public String saveAllShips(Model model){
        List<SpaceShip> allSpaceShips = (List<SpaceShip>) spaceShipRepo.findAll();
        model.addAttribute("allSpaceShips", allSpaceShips);

        return "allspaceships";
    }

    @GetMapping(value = {"/searchresult"})
    public String allActiveSpaceShips(Model model) {
        List<SpaceShip> spaceShipList = spaceShipRepo.findSpaceShipByisActiveTrue();
        model.addAttribute("results", spaceShipList);
        return "searchresult";
    }

    /*@GetMapping(value = {"/spaceshipcrew/{id}"})
    public String allCrewDates(@PathVariable ("id")Long id,Model model) {
        List<Crew> crewList = new ArrayList<>();
        crewList.addAll(spaceShipService.getAllCrewDates(id));
        model.addAttribute("allcrewdata", crewList);

        Optional<SpaceShip> ship = spaceShipService.(id);
        String name = ship.get().getName();
        model.addAttribute("shipName", name);

        return "crewdata";
    }*/

}

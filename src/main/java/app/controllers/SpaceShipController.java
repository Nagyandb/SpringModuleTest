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

import java.util.List;

@Controller
public class SpaceShipController {

    private SpaceShipRepo spaceShipRepo;
    private CrewRepo crewRepo;

    @Autowired
    public SpaceShipController(SpaceShipRepo spaceShipRepo) {
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

    @GetMapping(value = {"/showcrew"})
    public String allCrewDates(Model model) {
        List<Crew> crewList = crewRepo.findCrewBy();
        model.addAttribute("allcrewdata", crewList);
        return "crewdata";
    }

}

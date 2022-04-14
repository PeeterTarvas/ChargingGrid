package andmebaasid.projekt.controller;

import andmebaasid.projekt.entities.Laadimispunkt;
import andmebaasid.projekt.services.LaadimispunktiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laadimispunkt")
public class LaadimispunktController {

    @Autowired
    private LaadimispunktiService laadimispunktiService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Laadimispunkt> getAllLaadimispunkt() {
        return laadimispunktiService.getALlLaadimispunkt();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Laadimispunkt getLaadimispunktWithId(@PathVariable Long id) {
        return laadimispunktiService.getLaadimispunktWithId(id);
    }

    @GetMapping("/active")
    public List<Laadimispunkt> getAllActiveLaadimispunkt() {
        return laadimispunktiService.getAllActiveLaadimispunkt();
    }

    @GetMapping("/inactive")
    public List<Laadimispunkt> getAllInActiveLaadimispunkt() {
        return laadimispunktiService.getAllInactiveLaadimispunkt();
    }

    @GetMapping("/{id}/lopeta")
    public ResponseEntity<String> setLaadimispunktiSeisundiLiik(@PathVariable Long id) {
        laadimispunktiService.setLaadimispunktiSeisundiLiik(id, "lopetatud");
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }
}

package andmebaasid.projekt.controller;

import andmebaasid.projekt.entities.Laadimispunkt;
import andmebaasid.projekt.repositories.LaadimispunktRepository;
import andmebaasid.projekt.services.LaadimispunktiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/laadimispunkt")
public class LaadimispunktController {

    @Autowired
    private LaadimispunktiService laadimispunktiService;


    @GetMapping
    public List<Laadimispunkt> getAllLaadimispunkt() {
        return laadimispunktiService.getALlLaadimispunkt();
    }

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

    @PutMapping("/{id}/{status}")
    public void setLaadimispunktiSeisundiLiik(@PathVariable Long id, @PathVariable String status) {
        laadimispunktiService.setLaadimispunktiSeisundiLiik(id, status);
    }
}

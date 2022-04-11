package andmebaasid.projekt.controller;

import andmebaasid.projekt.entities.Laadimispunkt;
import andmebaasid.projekt.repositories.LaadimispunktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/laadimispunkt")
public class LaadimispunktController {

    @Autowired
    private LaadimispunktRepository laadimispunktRepository;

    @GetMapping
    public List<Laadimispunkt> getAllLaadimispunkt() {
        return laadimispunktRepository.findAll();
    }

    @GetMapping("/{id}")
    public Laadimispunkt getLaadimispunktWithId(@PathVariable Long id) {
        return laadimispunktRepository.findByLaadimispunktiKood(id);
    }

    // TODO
    @GetMapping("/active")
    public List<Laadimispunkt> getAllActiveLaadimispunkt() {
        return laadimispunktRepository.findAll();
    }

    // TODO
    @GetMapping("/inactive")
    public List<Laadimispunkt> getAllInActiveLaadimispunkt() {
        return laadimispunktRepository.findAll();
    }
}

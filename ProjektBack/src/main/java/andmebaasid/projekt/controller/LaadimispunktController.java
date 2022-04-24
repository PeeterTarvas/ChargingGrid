package andmebaasid.projekt.controller;

import andmebaasid.projekt.dto.KoondaruanneDTO;
import andmebaasid.projekt.dto.LaadimispunktDTO;
import andmebaasid.projekt.services.KoondaruanneService;
import andmebaasid.projekt.services.LaadimispunktiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laadimispunkt")
public class LaadimispunktController {

    @Autowired
    private LaadimispunktiService laadimispunktiService;

    @Autowired
    private KoondaruanneService koondaruanneService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<LaadimispunktDTO> getAllLaadimispunkt() {
        return laadimispunktiService.getALlLaadimispunkt();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public LaadimispunktDTO getLaadimispunktWithId(@PathVariable Long id) {
        return laadimispunktiService.getLaadimispunktWithId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/active")
    public List<LaadimispunktDTO> getAllActiveLaadimispunkt() {
        return laadimispunktiService.getAllActiveLaadimispunkt();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/inactive")
    public List<LaadimispunktDTO> getAllInActiveLaadimispunkt() {
        return laadimispunktiService.getAllInactiveLaadimispunkt();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/koondaruanne")
    public List<KoondaruanneDTO> getAllKoondaruanne() {
        return koondaruanneService.getAllKoondaruanne();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}/lopeta")
    public LaadimispunktDTO setLaadimispunktiSeisundiLiikLopetatud(@PathVariable Long id) {
        laadimispunktiService.setLaadimispunktiSeisundiLiik(id, "lopetatud");
        return laadimispunktiService.getLaadimispunktWithId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}/aktiveeri")
    public LaadimispunktDTO setLaadimispunktiSeisundiLiikAktiivne(@PathVariable Long id) {
        laadimispunktiService.setLaadimispunktiSeisundiLiik(id, "aktiivne");
        return laadimispunktiService.getLaadimispunktWithId(id);
    }
}

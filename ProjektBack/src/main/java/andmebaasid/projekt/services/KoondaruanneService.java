package andmebaasid.projekt.services;

import andmebaasid.projekt.entities.Koondaruanne;

import andmebaasid.projekt.entities.LaadimispunktiSeisundiLiik;
import andmebaasid.projekt.repositories.LaadimispunktiSeisundiLiikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class KoondaruanneService {
    @Autowired
    private LaadimispunktiService laadimispunktiService;
    @Autowired
    private LaadimispunktiSeisundiLiikRepository laadimispunktiSeisundiLiikRepository;

    public List<Koondaruanne> getAllKoondaruanne() {
        List<LaadimispunktiSeisundiLiik> seisundid = laadimispunktiSeisundiLiikRepository.findAll();
        HashMap<Long, Long> laadimispunktid = laadimispunktiService.getLaadimispunktCountByLiikId();
        List<Koondaruanne> koondaruanded = new LinkedList<>();
        for (LaadimispunktiSeisundiLiik seisund : seisundid) {
            Koondaruanne koondaruanne = new Koondaruanne();
            koondaruanne.setSeisundi_kood(seisund.getLaadimispunkti_seisundi_liik_kood());
            koondaruanne.setNimetus(seisund.getNimetus());
            koondaruanne.setLaadimispunktide_arv(laadimispunktid.getOrDefault(seisund.getLaadimispunkti_seisundi_liik_kood(), 0L));
            koondaruanded.add(koondaruanne);
        }
        System.out.println(koondaruanded);
        return koondaruanded;
    }
}

package andmebaasid.projekt.services;

import andmebaasid.projekt.entities.Laadimispunkt;
import andmebaasid.projekt.repositories.LaadimispunktRepository;
import andmebaasid.projekt.repositories.LaadimispunktiSeisundiLiikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class LaadimispunktiService {

    @Autowired
    private LaadimispunktRepository laadimispunktRepository;
    @Autowired
    private LaadimispunktiSeisundiLiikRepository laadimispunktiSeisundiLiikRepository;

    public List<Laadimispunkt> getALlLaadimispunkt() {
        return laadimispunktRepository.findAll();
    }

    public Laadimispunkt getLaadimispunktWithId(Long id) {
        return laadimispunktRepository.findByLaadimispunktiKood(id);
    }

    public List<Laadimispunkt> getAllActiveLaadimispunkt() {
        List<Laadimispunkt> laadimispunktList = new LinkedList<>();
        for (Laadimispunkt laadimispunkt : laadimispunktRepository.findAll()) {
            if (Objects.equals(laadimispunktiSeisundiLiikRepository
                    .findByLaadimispunktiSeisundiLiikKood(laadimispunkt.getLaadimispunkti_seisundi_liik_kood()).getNimetus(), "aktiivne")) {
                laadimispunktList.add(laadimispunkt);
            }
        }
        return laadimispunktList;
    }

    public List<Laadimispunkt> getAllInactiveLaadimispunkt() {
        List<Laadimispunkt> laadimispunktList = new LinkedList<>();
        for (Laadimispunkt laadimispunkt : laadimispunktRepository.findAll()) {
            if (Objects.equals(laadimispunktiSeisundiLiikRepository
                    .findByLaadimispunktiSeisundiLiikKood(laadimispunkt.getLaadimispunkti_seisundi_liik_kood()).getNimetus(), "mitteaktiivne")) {
                laadimispunktList.add(laadimispunkt);
            }
        }
        return laadimispunktList;
    }

    @Transactional
    public void setLaadimispunktiSeisundiLiik(Long id, String status) {
        Long laadimispunktiSeisundiLiikId = laadimispunktiSeisundiLiikRepository.findIdByStatus(status);
        laadimispunktRepository.updateLaadimispunktStatus(id, laadimispunktiSeisundiLiikId);
    }
}

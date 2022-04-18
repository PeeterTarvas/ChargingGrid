package andmebaasid.projekt.services;

import andmebaasid.projekt.entities.Isik;
import andmebaasid.projekt.entities.Laadimispunkt;
import andmebaasid.projekt.dto.LaadimispunktDTO;
import andmebaasid.projekt.repositories.IsikRepository;
import andmebaasid.projekt.repositories.LaadimispunktRepository;
import andmebaasid.projekt.repositories.LaadimispunktiSeisundiLiikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class LaadimispunktiService {

    @Autowired
    private LaadimispunktRepository laadimispunktRepository;
    @Autowired
    private LaadimispunktiSeisundiLiikRepository laadimispunktiSeisundiLiikRepository;
    @Autowired
    private IsikRepository isikRepository;

    public LaadimispunktDTO mapLaadimispunktToLaadimispunktDTO(Laadimispunkt laadimispunkt) {
        LaadimispunktDTO laadimispunktDTO = new LaadimispunktDTO();
        laadimispunktDTO.setLaadimispunkti_kood(laadimispunkt.getLaadimispunkti_kood());
        laadimispunktDTO.setLaadimispunkti_tyyp_id(laadimispunkt.getLaadimispunkti_tyyp_id());
        laadimispunktDTO.setLaadimispunkti_seisundi_nimetus(laadimispunktiSeisundiLiikRepository.findByLaadimispunktiSeisundiLiikKood(laadimispunkt.getLaadimispunkti_seisundi_liik_kood()).getNimetus());
        laadimispunktDTO.setLaadimispunkti_seisundi_liik_kood(laadimispunkt.getLaadimispunkti_seisundi_liik_kood());
        laadimispunktDTO.setNimetus(laadimispunkt.getNimetus());
        laadimispunktDTO.setLaiuskraad(laadimispunkt.getLaiuskraad());
        laadimispunktDTO.setPikkuskraad(laadimispunkt.getPikkuskraad());
        laadimispunktDTO.setReg_aeg(laadimispunkt.getReg_aeg());
        laadimispunktDTO.setRegistreerija_id(laadimispunkt.getRegistreerija_id());
        Isik isik = isikRepository.findByIsikId(laadimispunkt.getRegistreerija_id());
        laadimispunktDTO.setEesnimi(isik.getEesnimi());
        laadimispunktDTO.setPerenimi(isik.getPerenimi());
        laadimispunktDTO.setE_post(isik.getE_meil());
        return laadimispunktDTO;
    }

    public List<LaadimispunktDTO> getALlLaadimispunkt() {
        List<LaadimispunktDTO> laadimispunktDTOs = new LinkedList<>();
        for (Laadimispunkt laadimispunkt : laadimispunktRepository.findAll()) {
            laadimispunktDTOs.add(this.mapLaadimispunktToLaadimispunktDTO(laadimispunkt));
        }
        return laadimispunktDTOs;
    }

    public LaadimispunktDTO getLaadimispunktWithId(Long id) {
        return mapLaadimispunktToLaadimispunktDTO(laadimispunktRepository.findByLaadimispunktiKood(id));
    }

    public List<LaadimispunktDTO> getAllActiveLaadimispunkt() {
        List<LaadimispunktDTO> laadimispunktList = new LinkedList<>();
        for (Laadimispunkt laadimispunkt : laadimispunktRepository.findAll()) {
            if (Objects.equals(laadimispunktiSeisundiLiikRepository
                    .findByLaadimispunktiSeisundiLiikKood(laadimispunkt.getLaadimispunkti_seisundi_liik_kood()).getNimetus(), "aktiivne")) {
                laadimispunktList.add(mapLaadimispunktToLaadimispunktDTO(laadimispunkt));
            }
        }
        return laadimispunktList;
    }

    public List<LaadimispunktDTO> getAllInactiveLaadimispunkt() {
        List<LaadimispunktDTO> laadimispunktList = new LinkedList<>();
        for (Laadimispunkt laadimispunkt : laadimispunktRepository.findAll()) {
            if (Objects.equals(laadimispunktiSeisundiLiikRepository
                    .findByLaadimispunktiSeisundiLiikKood(laadimispunkt.getLaadimispunkti_seisundi_liik_kood()).getNimetus(), "mitteaktiivne")) {
                laadimispunktList.add(mapLaadimispunktToLaadimispunktDTO(laadimispunkt));
            }
        }
        return laadimispunktList;
    }

    @Transactional
    public void setLaadimispunktiSeisundiLiik(Long id, String status) {
        Long laadimispunktiSeisundiLiikId = laadimispunktiSeisundiLiikRepository.findIdByStatus(status);
        laadimispunktRepository.updateLaadimispunktStatus(id, laadimispunktiSeisundiLiikId);
    }

    public HashMap<Long, Long> getLaadimispunktCountByLiikId() {
        List<LaadimispunktDTO> laadimispunktid = this.getALlLaadimispunkt();
        HashMap<Long, Long> countById = new LinkedHashMap<>();
        for (LaadimispunktDTO laadimispunkt : laadimispunktid) {
            Long kood = laadimispunkt.getLaadimispunkti_seisundi_liik_kood();
            countById.putIfAbsent(kood, 0L);
            countById.put(kood, countById.get(kood) + 1);
        }
        return countById;
    }
}

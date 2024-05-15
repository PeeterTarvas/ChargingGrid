package andmebaasid.projekt.services;

import andmebaasid.projekt.dto.KategooriaDTO;
import andmebaasid.projekt.entities.Isik;
import andmebaasid.projekt.entities.Laadimispunkt;
import andmebaasid.projekt.dto.LaadimispunktDTO;
import andmebaasid.projekt.entities.LaadimispunktiKategooria;
import andmebaasid.projekt.entities.LaadimispunktiKategooriaOmamine;
import andmebaasid.projekt.repositories.IsikRepository;
import andmebaasid.projekt.repositories.LaadimispunktRepository;
import andmebaasid.projekt.repositories.LaadimispunktiKategooriaOmamineRepository;
import andmebaasid.projekt.repositories.LaadimispunktiKategooriaRepository;
import andmebaasid.projekt.repositories.LaadimispunktiKategooriaTyypRepository;
import andmebaasid.projekt.repositories.LaadimispunktiSeisundiLiikRepository;
import andmebaasid.projekt.repositories.LaadimispunktiTyypRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class LaadimispunktiService {

    @Autowired
    private LaadimispunktRepository lR;
    @Autowired
    private LaadimispunktiSeisundiLiikRepository lSLR;
    @Autowired
    private IsikRepository iR;
    @Autowired
    private LaadimispunktiTyypRepository lTR;
    @Autowired
    private LaadimispunktiKategooriaOmamineRepository lKOR;
    @Autowired
    private LaadimispunktiKategooriaRepository lKR;
    @Autowired
    private LaadimispunktiKategooriaTyypRepository lKTR;

    public LaadimispunktDTO mapLaadimispunktToLaadimispunktDTO(Laadimispunkt laadimispunkt) {
        LaadimispunktDTO laadimispunktDTO = new LaadimispunktDTO();
        laadimispunktDTO.setLaadimispunkti_kood(laadimispunkt.getLaadimispunkti_kood());
        laadimispunktDTO.setLaadimispunkti_tyyp_id(laadimispunkt.getLaadimispunkti_tyyp_kood());
        laadimispunktDTO.setLaadimispunkti_seisundi_nimetus(lSLR
                .findByLaadimispunktiSeisundiLiikKood(laadimispunkt.getLaadimispunkti_seisundi_liik_kood()).getLaadimispunkti_seisundi_liik_nimetus());
        laadimispunktDTO.setLaadimispunkti_seisundi_liik_kood(laadimispunkt.getLaadimispunkti_seisundi_liik_kood());
        laadimispunktDTO.setNimetus(laadimispunkt.getLaadimispunkti_nimetus());
        laadimispunktDTO.setLaiuskraad(laadimispunkt.getLaiuskraad());
        laadimispunktDTO.setPikkuskraad(laadimispunkt.getPikkuskraad());
        laadimispunktDTO.setReg_aeg(laadimispunkt.getReg_aeg());
        laadimispunktDTO.setRegistreerija_id(laadimispunkt.getRegistreerija_id());
        Isik isik = iR.findByIsikId(laadimispunkt.getRegistreerija_id());
        laadimispunktDTO.setEesnimi(isik.getEesnimi());
        laadimispunktDTO.setPerenimi(isik.getPerenimi());
        laadimispunktDTO.setE_post(isik.getE_meil());
        laadimispunktDTO.setLaadimispunkti_tyyp_nimi(lTR
                .findByLaadimispunkti_tyyp_kood(laadimispunkt.getLaadimispunkti_tyyp_kood()).getKwh());

        // Klassifikaatorid
        List<LaadimispunktiKategooriaOmamine> omamised = lKOR.findAll();
        omamised.removeIf(n -> (!Objects.equals(n.getLaadimispunkti_kood(), laadimispunkt.getLaadimispunkti_kood())));
        Map<Integer, KategooriaDTO> kategooriad = new LinkedHashMap<>();
        for (LaadimispunktiKategooriaOmamine omamine : omamised) {
            KategooriaDTO kategooriaDTO = new KategooriaDTO();
            LaadimispunktiKategooria laadimispunktiKategooria = lKR
                    .findKategooriaByKood(omamine.getLaadimispunkti_kategooria_kood());
            kategooriaDTO.setKategooriaNimetus(laadimispunktiKategooria.getLaadimispunkti_kategooria_nimetus());
            kategooriaDTO.setKategooriaTyypNimeus(lKTR.findKategooriaTyypNimetusByKood(laadimispunktiKategooria.getLaadimispunkti_kategooria_tyyp_kood()));
            kategooriad.put(laadimispunktiKategooria.getLaadimispunkti_kategooria_kood(), kategooriaDTO);
        }
        laadimispunktDTO.setKategooriad(kategooriad);
        return laadimispunktDTO;
    }

    public List<LaadimispunktDTO> getALlLaadimispunkt() {
        List<LaadimispunktDTO> laadimispunktDTOs = new LinkedList<>();
        for (Laadimispunkt laadimispunkt : lR.findAll()) {
            laadimispunktDTOs.add(this.mapLaadimispunktToLaadimispunktDTO(laadimispunkt));
        }
        return laadimispunktDTOs;
    }

    public LaadimispunktDTO getLaadimispunktWithId(Long id) {
        return mapLaadimispunktToLaadimispunktDTO(lR.findByLaadimispunktiKood(id));
    }

    public List<LaadimispunktDTO> getAllActiveLaadimispunkt() {
        List<LaadimispunktDTO> laadimispunktList = new LinkedList<>();
        for (Laadimispunkt laadimispunkt : lR.findAll()) {
            if (Objects.equals(lSLR
                    .findByLaadimispunktiSeisundiLiikKood(laadimispunkt.getLaadimispunkti_seisundi_liik_kood()).getLaadimispunkti_seisundi_liik_nimetus(), "aktiivne")) {
                laadimispunktList.add(mapLaadimispunktToLaadimispunktDTO(laadimispunkt));
            }
        }
        return laadimispunktList;
    }

    public List<LaadimispunktDTO> getAllInactiveLaadimispunkt() {
        List<LaadimispunktDTO> laadimispunktList = new LinkedList<>();
        for (Laadimispunkt laadimispunkt : lR.findAll()) {
            if (Objects.equals(lSLR
                    .findByLaadimispunktiSeisundiLiikKood(laadimispunkt.getLaadimispunkti_seisundi_liik_kood()).getLaadimispunkti_seisundi_liik_nimetus(), "mitteaktiivne")) {
                laadimispunktList.add(mapLaadimispunktToLaadimispunktDTO(laadimispunkt));
            }
        }
        return laadimispunktList;
    }

    @Transactional
    public void setLaadimispunktiSeisundiLiik(Long id, String status) {
        Long laadimispunktiSeisundiLiikId = lSLR.findIdByStatus(status);
        lR.updateLaadimispunktStatus(id, laadimispunktiSeisundiLiikId);
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

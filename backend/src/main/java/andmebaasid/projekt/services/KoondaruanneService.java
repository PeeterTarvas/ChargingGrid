package andmebaasid.projekt.services;

import andmebaasid.projekt.dto.KoondaruanneDTO;

import andmebaasid.projekt.entities.LaadimispunktiSeisundiLiik;
import andmebaasid.projekt.repositories.LaadimispunktiSeisundiLiikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KoondaruanneService {
    @Autowired
    private LaadimispunktiService lS;
    @Autowired
    private LaadimispunktiSeisundiLiikRepository lSLR;

    public List<KoondaruanneDTO> getAllKoondaruanne() {
        List<LaadimispunktiSeisundiLiik> seisundid = lSLR.findAll();
        HashMap<Long, Long> laadimispunktid = lS.getLaadimispunktCountByLiikId();
        List<KoondaruanneDTO> koondaruanded = new LinkedList<>();
        for (LaadimispunktiSeisundiLiik seisund : seisundid) {
            KoondaruanneDTO koondaruanneDTO = new KoondaruanneDTO();
            koondaruanneDTO.setSeisundi_kood(seisund.getLaadimispunkti_seisundi_liik_kood());
            koondaruanneDTO.setNimetus(seisund.getLaadimispunkti_seisundi_liik_nimetus());
            koondaruanneDTO.setLaadimispunktide_arv(laadimispunktid.getOrDefault(seisund.getLaadimispunkti_seisundi_liik_kood(), 0L));
            koondaruanded.add(koondaruanneDTO);
        }
        return koondaruanded
                .stream()
                .sorted(Comparator.comparingLong(KoondaruanneDTO::getLaadimispunktide_arv).reversed()
                        .thenComparing(KoondaruanneDTO::getNimetus))
                .collect(Collectors.toList());
    }
}

package andmebaasid.projekt.repositories;

import andmebaasid.projekt.model.LaadimispunktiSeisundiLiik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaadimispunktRepo extends JpaRepository<LaadimispunktiSeisundiLiik, Integer> {

    LaadimispunktiSeisundiLiik findLaadimispunktiSeisundiLiikBylaadimispunkti_seisundi_liik_kood(Integer kood);

}

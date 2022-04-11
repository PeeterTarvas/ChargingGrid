package andmebaasid.projekt.repositories;

import andmebaasid.projekt.entities.LaadimispunktiSeisundiLiik;
import andmebaasid.projekt.model.ModelTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaadimispunktiSeisundiLiikRepository extends JpaRepository<LaadimispunktiSeisundiLiik, Integer> {

    @Query("SELECT l FROM LaadimispunktiSeisundiLiik l WHERE l.laadimispunkti_seisundi_liik_kood = :kood")
    LaadimispunktiSeisundiLiik findByLaadimispunktiSeisundiLiikKood(Integer kood);
}

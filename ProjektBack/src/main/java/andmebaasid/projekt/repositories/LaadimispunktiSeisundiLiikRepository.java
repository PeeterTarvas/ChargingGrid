package andmebaasid.projekt.repositories;

import andmebaasid.projekt.model.ModelTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaadimispunktiSeisundiLiikRepository extends JpaRepository<ModelTest, Integer> {

    @Query("SELECT l FROM LaadimisPunktiSeisundiLiik l WHERE l.laadimispunkti_seisundi_liik_kood = :kood")
    Integer findBylaadimispunkti_seisundi_liik_kood(Integer kood);

}

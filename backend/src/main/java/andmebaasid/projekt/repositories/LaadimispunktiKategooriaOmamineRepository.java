package andmebaasid.projekt.repositories;

import andmebaasid.projekt.entities.LaadimispunktiKategooriaOmamine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaadimispunktiKategooriaOmamineRepository extends JpaRepository<LaadimispunktiKategooriaOmamine, Integer> {

    @Query("SELECT l FROM LaadimispunktiKategooriaOmamine l WHERE l.laadimispunkti_kood=:kood")
    List<LaadimispunktiKategooriaOmamine> findKategooriaByLaadimispunktiKood(Long kood);
}

package andmebaasid.projekt.repositories;

import andmebaasid.projekt.entities.Laadimispunkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LaadimispunktRepository extends JpaRepository<Laadimispunkt, Integer> {

    @Query("SELECT l FROM Laadimispunkt l WHERE l.laadimispunkti_kood = :kood")
    Laadimispunkt findByLaadimispunktiKood(Long kood);
}

package andmebaasid.projekt.repositories;

import andmebaasid.projekt.model.ModelTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Lazy
@Repository
public interface TestRepo extends JpaRepository<ModelTest, Integer> {

    Integer findModelTestByKood(Integer kood);

}

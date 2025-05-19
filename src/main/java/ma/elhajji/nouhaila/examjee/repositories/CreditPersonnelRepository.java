package ma.elhajji.nouhaila.examjee.repositories;



import ma.elhajji.nouhaila.examjee.entities.CreditPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel, Long> {
}
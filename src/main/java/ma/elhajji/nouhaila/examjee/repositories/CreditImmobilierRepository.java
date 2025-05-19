package ma.elhajji.nouhaila.examjee.repositories;



import ma.elhajji.nouhaila.examjee.entities.CreditImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
}
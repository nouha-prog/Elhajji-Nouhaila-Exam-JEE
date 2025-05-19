package ma.elhajji.nouhaila.examjee.repositories;



import ma.elhajji.nouhaila.examjee.entities.CreditProfessionnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditProfessionnelRepository extends JpaRepository<CreditProfessionnel, Long> {
}
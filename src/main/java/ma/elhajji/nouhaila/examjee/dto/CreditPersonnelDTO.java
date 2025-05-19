package ma.elhajji.nouhaila.examjee.dto;



import ma.elhajji.nouhaila.examjee.enums.StatutCredit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnelDTO extends CreditDTO{
    private String motif;

    public CreditPersonnelDTO(Long id, LocalDate dateDemande, StatutCredit statut, LocalDate dateAcceptation,
                              Double montant, Integer dureeRemboursement, Double tauxInteret,
                              Long clientId, String motif) {
        super(id, dateDemande, statut, dateAcceptation, montant, dureeRemboursement, tauxInteret, clientId, null, "PERSONNEL");
        this.motif = motif;
    }
}
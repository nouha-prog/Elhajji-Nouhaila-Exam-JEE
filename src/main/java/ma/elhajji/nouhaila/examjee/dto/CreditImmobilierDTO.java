package ma.elhajji.nouhaila.examjee.dto;



import ma.elhajji.nouhaila.examjee.enums.StatutCredit;
import ma.elhajji.nouhaila.examjee.enums.TypeBien;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;

    public CreditImmobilierDTO(Long id, LocalDate dateDemande, StatutCredit statut, LocalDate dateAcceptation,
                               Double montant, Integer dureeRemboursement, Double tauxInteret,
                               Long clientId, TypeBien typeBien) {
        super(id, dateDemande, statut, dateAcceptation, montant, dureeRemboursement, tauxInteret, clientId, null, "IMMOBILIER");
        this.typeBien = typeBien;
    }
}
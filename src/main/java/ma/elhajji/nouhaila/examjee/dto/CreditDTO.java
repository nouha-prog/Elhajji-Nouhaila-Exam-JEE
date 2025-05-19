package ma.elhajji.nouhaila.examjee.dto;



import ma.elhajji.nouhaila.examjee.enums.StatutCredit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CreditDTO {
    private Long id;
    private LocalDate dateDemande;
    private StatutCredit statut;
    private LocalDate dateAcceptation;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;
    private Long clientId;
    private List<Long> remboursementIds;
    private String typeCredit; // PERSONNEL, IMMOBILIER, PROFESSIONNEL
}
package ma.elhajji.nouhaila.examjee.entities;


import ma.elhajji.nouhaila.examjee.enums.StatutCredit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("PERSONNEL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnel extends Credit {

    @Column(nullable = false)
    private String motif;

    public CreditPersonnel(LocalDate dateDemande, StatutCredit statut, Double montant, Integer dureeRemboursement, Double tauxInteret, Client client, String motif) {
        super(dateDemande, statut, montant, dureeRemboursement, tauxInteret, client);
        this.motif = motif;
    }
}
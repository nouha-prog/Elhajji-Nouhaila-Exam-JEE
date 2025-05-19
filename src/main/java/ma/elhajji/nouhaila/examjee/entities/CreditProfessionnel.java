package ma.elhajji.nouhaila.examjee.entities;

import ma.elhajji.nouhaila.examjee.enums.StatutCredit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("PROFESSIONNEL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditProfessionnel extends Credit {

    @Column(nullable = false)
    private String motif;

    @Column(nullable = false)
    private String raisonSociale;

    public CreditProfessionnel(LocalDate dateDemande, StatutCredit statut, Double montant, Integer dureeRemboursement, Double tauxInteret, Client client, String motif, String raisonSociale) {
        super(dateDemande, statut, montant, dureeRemboursement, tauxInteret, client);
        this.motif = motif;
        this.raisonSociale = raisonSociale;
    }
}
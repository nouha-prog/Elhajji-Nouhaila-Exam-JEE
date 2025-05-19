package ma.elhajji.nouhaila.examjee.entities;
import ma.elhajji.nouhaila.examjee.entities.Client;
import ma.elhajji.nouhaila.examjee.enums.StatutCredit;
import ma.elhajji.nouhaila.examjee.enums.TypeBien;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("IMMOBILIER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditImmobilier extends Credit {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeBien typeBien;

    public CreditImmobilier(LocalDate dateDemande, StatutCredit statut, Double montant, Integer dureeRemboursement, Double tauxInteret, Client client, TypeBien typeBien) {
        super(dateDemande, statut, montant, dureeRemboursement, tauxInteret, client);
        this.typeBien = typeBien;
    }
}
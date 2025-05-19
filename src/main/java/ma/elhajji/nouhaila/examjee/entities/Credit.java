package ma.elhajji.nouhaila.examjee.entities;

import ma.elhajji.nouhaila.examjee.enums.StatutCredit;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "credit")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_credit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateDemande;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutCredit statut;

    private LocalDate dateAcceptation;

    @Column(nullable = false)
    private Double montant;

    @Column(nullable = false)
    private Integer dureeRemboursement;

    @Column(nullable = false)
    private Double tauxInteret;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private com.elhajji.nouhaila.examjee.entity.Client client;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Remboursement> remboursements;

    // Constructeur pour les sous-classes
    public Credit(LocalDate dateDemande, StatutCredit statut, Double montant, Integer dureeRemboursement, Double tauxInteret, Client client) {
        this.dateDemande = dateDemande;
        this.statut = statut;
        this.montant = montant;
        this.dureeRemboursement = dureeRemboursement;
        this.tauxInteret = tauxInteret;
        this.client = client;
    }
}
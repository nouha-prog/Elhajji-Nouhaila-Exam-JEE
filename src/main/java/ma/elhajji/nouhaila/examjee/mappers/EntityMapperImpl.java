package ma.elhajji.nouhaila.examjee.mappers;

import ma.elhajji.nouhaila.examjee.dto.*;
import ma.elhajji.nouhaila.examjee.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EntityMapperImpl {

    // Client
    public ClientDTO fromClient(Client client) {
        ClientDTO dto = new ClientDTO();
        BeanUtils.copyProperties(client, dto);
        return dto;
    }
    public Client fromClientDTO(ClientDTO dto) {
        Client entity = new Client();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    // Méthode pour mapper un Credit (entité) vers le bon DTO selon son type concret
    public CreditDTO fromCredit(Credit credit) {
        if (credit instanceof CreditProfessionnel cp) {
            CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
            BeanUtils.copyProperties(cp, dto);
            return dto;
        } else if (credit instanceof CreditImmobilier ci) {
            CreditImmobilierDTO dto = new CreditImmobilierDTO();
            BeanUtils.copyProperties(ci, dto);
            return dto;
        } else if (credit instanceof CreditPersonnel cpe) {
            CreditPersonnelDTO dto = new CreditPersonnelDTO();
            BeanUtils.copyProperties(cpe, dto);
            return dto;
        } else {
            throw new IllegalArgumentException("Type de crédit inconnu");
        }
    }

    // Méthode pour mapper un DTO vers une entité Credit concrète selon le type du DTO
    public Credit fromCreditDTO(CreditDTO dto) {
        if (dto instanceof CreditProfessionnelDTO cpDTO) {
            CreditProfessionnel entity = new CreditProfessionnel();
            BeanUtils.copyProperties(cpDTO, entity);
            return entity;
        } else if (dto instanceof CreditImmobilierDTO ciDTO) {
            CreditImmobilier entity = new CreditImmobilier();
            BeanUtils.copyProperties(ciDTO, entity);
            return entity;
        } else if (dto instanceof CreditPersonnelDTO cpeDTO) {
            CreditPersonnel entity = new CreditPersonnel();
            BeanUtils.copyProperties(cpeDTO, entity);
            return entity;
        } else {
            throw new IllegalArgumentException("Type de DTO crédit inconnu");
        }
    }

    // Remboursement
    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(remboursement, dto);
        return dto;
    }
    public Remboursement fromRemboursementDTO(RemboursementDTO dto) {
        Remboursement entity = new Remboursement();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    // CreditProfessionnel
    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel creditProfessionnel) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(creditProfessionnel, dto);
        return dto;
    }
    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO dto) {
        CreditProfessionnel entity = new CreditProfessionnel();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    // CreditImmobilier
    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier creditImmobilier) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(creditImmobilier, dto);
        return dto;
    }
    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO dto) {
        CreditImmobilier entity = new CreditImmobilier();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    // CreditPersonnel
    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel creditPersonnel) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(creditPersonnel, dto);
        return dto;
    }
    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO dto) {
        CreditPersonnel entity = new CreditPersonnel();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}

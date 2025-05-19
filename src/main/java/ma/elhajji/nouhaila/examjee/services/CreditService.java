package ma.elhajji.nouhaila.examjee.services;

import ma.elhajji.nouhaila.examjee.dto.*;
import ma.elhajji.nouhaila.examjee.entities.*;
import ma.elhajji.nouhaila.examjee.mappers.EntityMapperImpl;
import ma.elhajji.nouhaila.examjee.repositories.*; // à créer pour tes repositories
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CreditService {

    private final CreditRepository creditRepository;  // Interface JpaRepository pour Credit et ses sous-classes
    private final EntityMapperImpl mapper;

    public CreditService(CreditRepository creditRepository, EntityMapperImpl mapper) {
        this.creditRepository = creditRepository;
        this.mapper = mapper;
    }

    public List<CreditDTO> getAllCredits() {
        return creditRepository.findAll()
                .stream()
                .map(mapper::fromCredit)
                .collect(Collectors.toList());
    }

    public CreditDTO getCredit(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit non trouvé avec l'id : " + id));
        return mapper.fromCredit(credit);
    }

    public CreditDTO saveCredit(CreditDTO creditDTO) {
        Credit credit = mapper.fromCreditDTO(creditDTO);
        Credit savedCredit = creditRepository.save(credit);
        return mapper.fromCredit(savedCredit);
    }

    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}

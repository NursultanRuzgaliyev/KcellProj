package kz.ruzgaliyev.kcell.repository;

import kz.ruzgaliyev.kcell.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyEntityRepository  extends JpaRepository<CurrencyEntity, Long> {
    CurrencyEntity findByCodeIgnoreCase(String code);

}

package kz.ruzgaliyev.kcell.repository;

import kz.ruzgaliyev.kcell.entity.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory,Long> {

}

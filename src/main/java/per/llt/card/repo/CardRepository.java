package per.llt.card.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import per.llt.card.entity.Cards;

@Repository
public interface CardRepository extends JpaRepository<Cards,Long> {
}

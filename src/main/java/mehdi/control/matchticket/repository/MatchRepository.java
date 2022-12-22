package mehdi.control.matchticket.repository;

import mehdi.control.matchticket.Models.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,Long> {
}

package mehdi.control.matchticket.services.ServiceImpl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mehdi.control.matchticket.DTO.MatchRequestDto;
import mehdi.control.matchticket.Models.Match;
import mehdi.control.matchticket.repository.MatchRepository;

import mehdi.control.matchticket.services.IMatchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
@Transactional
@AllArgsConstructor
public class MatchService implements IMatchService {
    private MatchRepository matchRepository;
    @Override
    public Match addMatch(MatchRequestDto matchRequest) {
        Random random = new Random();
        Match match = new Match();
        match.setId(random.nextLong());
        match.setLieu(matchRequest.lieu());
        match.setMatchDate(matchRequest.matchDate());
        match.setEquipe1(matchRequest.equipe1());
        match.setEquipe2(matchRequest.equipe2());

        match.setReference(String.valueOf(random.nextLong(1,2022)));
        return matchRepository.save(match);
    }
    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
    @Override
    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
        .orElseThrow(() ->
         new RuntimeException("Match not found")
         );
    }
}

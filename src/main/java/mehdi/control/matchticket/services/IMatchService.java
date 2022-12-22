package mehdi.control.matchticket.services;

import mehdi.control.matchticket.DTO.MatchRequestDto;
import mehdi.control.matchticket.Models.Match;

import java.util.List;

public interface IMatchService {
    public Match addMatch(MatchRequestDto matchRequestDto);
    public List<Match> getAllMatches();
    public Match getMatchById(Long id);
}

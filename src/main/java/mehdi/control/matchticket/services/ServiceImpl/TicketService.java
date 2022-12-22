package mehdi.control.matchticket.services.ServiceImpl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mehdi.control.matchticket.DTO.TicketRequestDto;
import mehdi.control.matchticket.Models.Match;
import mehdi.control.matchticket.Models.Ticket;
import mehdi.control.matchticket.repository.MatchRepository;
import mehdi.control.matchticket.repository.TicketRepository;

import mehdi.control.matchticket.services.ITicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Transactional
@AllArgsConstructor
public class TicketService implements ITicketService {
    private TicketRepository ticketRepository;
    private MatchRepository matchRepository;


    @Override
    public Ticket addTicket(TicketRequestDto ticketRequest) {
       Match match = matchRepository.findById(ticketRequest.matchId()).orElse(null);
        Integer totalticketByMatch  = ticketRepository.countTicketByMatch_Id(match.getId());
        if( totalticketByMatch > 10) {
            throw new RuntimeException("Ticket are not available !");
        }
        Random random = new Random();
        Ticket ticket = new Ticket();
        ticket.setId(random.nextLong());
        ticket.setAchete(false);
        ticket.setReference(String.valueOf(random.nextLong(1,2022)));
        ticket.setPrix(ticketRequest.prix());
        ticket.setMatch(match);
        ticket.setStatut(true);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Ticket %s not found",id))
        );
    }

    @Override
    public Ticket updateTicket(Long id, TicketRequestDto ticketRequest) {
        Match match = matchRepository.findById(ticketRequest.matchId()).orElse(null);

        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Ticket %s Not founf",id))
        );


        ticket.setId(id);
        ticket.setAchete(ticketRequest.achete());
        ticket.setPrix(ticketRequest.prix());
        ticket.setMatch(match);
        ticket.setStatut(ticketRequest.statut());
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

}
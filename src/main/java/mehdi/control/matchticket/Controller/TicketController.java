package mehdi.control.matchticket.Controller;

import lombok.AllArgsConstructor;
import mehdi.control.matchticket.DTO.MatchRequestDto;
import mehdi.control.matchticket.DTO.TicketRequestDto;
import mehdi.control.matchticket.Models.Match;
import mehdi.control.matchticket.Models.Ticket;
import mehdi.control.matchticket.repository.TicketRepository;
import mehdi.control.matchticket.services.IMatchService;
import mehdi.control.matchticket.services.ITicketService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class TicketController {
    private TicketRepository ticketRepository;
    private IMatchService matchService;
    private ITicketService ticketService;

    @QueryMapping
    public List<Match> matchs(){
        return matchService.getAllMatches();
    }
    @QueryMapping
    public Match matchById(@Argument Long id){
            return matchService.getMatchById(id);
    }
    @MutationMapping
    public Match saveMatch(@Argument MatchRequestDto matchRequest){
        return matchService.addMatch(matchRequest);
    }
    @QueryMapping
    public List<Ticket> ticketList(){
        return ticketService.getAllTickets();
    }
    @QueryMapping
    public Ticket ticketById(@Argument Long id){
        return ticketService.getTicketById(id);
    }
    @MutationMapping
    public Ticket saveTicket(@Argument TicketRequestDto ticketRequest){
        return ticketService.addTicket(ticketRequest);
    }
    @MutationMapping
    public Ticket updateTicket(@Argument Long id,@Argument TicketRequestDto ticketRequest){
        return ticketService.updateTicket(id,ticketRequest);
    }
    @MutationMapping
    public void deleteTicket(@Argument Long id){
        ticketService.deleteTicket(id);
    }

}

package mehdi.control.matchticket.DTO;
import mehdi.control.matchticket.Models.Ticket;

import java.util.Date;
import java.util.List;

public record MatchRequestDto (
     String reference,
     Date matchDate,
     String lieu,
     String equipe1,
     String equipe2,
     List<Ticket> tickets
){}


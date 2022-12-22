package mehdi.control.matchticket.services;

import mehdi.control.matchticket.DTO.TicketRequestDto;
import mehdi.control.matchticket.Models.Ticket;

import java.util.List;

public interface ITicketService {
    public Ticket addTicket(TicketRequestDto ticketRequestDto);
    public List<Ticket> getAllTickets();
    public Ticket getTicketById(Long id);
    public Ticket updateTicket( Long id, TicketRequestDto ticketRequest);
    public void deleteTicket(Long id);
}
package mehdi.control.matchticket.repository;

import mehdi.control.matchticket.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    public Integer countTicketByMatch_Id(Long Id);
}

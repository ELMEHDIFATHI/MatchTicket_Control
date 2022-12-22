package mehdi.control.matchticket;

import mehdi.control.matchticket.Models.Match;
import mehdi.control.matchticket.Models.Ticket;
import mehdi.control.matchticket.repository.MatchRepository;
import mehdi.control.matchticket.repository.TicketRepository;
;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class MatchTicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatchTicketsApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(MatchRepository matchRepository, TicketRepository ticketRepository){
        return args -> {
            Random random = new Random();
            List.of("MAROC_FRANCE").forEach(m->{
                Match match  = Match.builder()
                        .reference(String.valueOf(random.nextLong(1,2022)))
                        .matchDate(new Date())
                        .equipe1("MAROC")
                        .equipe2("FRANCE")
                        .lieu("maroc")
                        .build();
                Match match1  = Match.builder()
                        .reference(String.valueOf(random.nextLong(1,2022)))
                        .matchDate(new Date())
                        .equipe1("MAROC")
                        .equipe2("Croite")
                        .lieu("Qatar")
                        .build();

                matchRepository.save(match);
                matchRepository.save(match1);
            });
            matchRepository.findAll().forEach(m->{
                Random random1 = new Random();
                for (int i = 0; i < 10; i++) {
                    Ticket ticket = Ticket.builder()  .reference(String.valueOf(random.nextLong(1,2022)))
                            .statut(true)
                            .achete(false)
                            .prix(100.00)
                            .match(m)
                            .build();
                    ticketRepository.save(ticket);
                }
            });


        };
    }

}

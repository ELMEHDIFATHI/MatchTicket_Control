package mehdi.control.matchticket.DTO;

public record TicketRequestDto(
        Double prix,
        Boolean achete,
        Boolean statut,
        Long matchId
) {
}

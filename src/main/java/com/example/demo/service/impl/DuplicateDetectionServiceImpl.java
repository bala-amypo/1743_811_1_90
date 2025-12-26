@Service
@RequiredArgsConstructor
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepository;
    private final DuplicateDetectionLogRepository logRepository;
    private final DuplicateRuleRepository ruleRepository;

    @Override
    public void detectDuplicates(long ticketId) {
        Ticket base = ticketRepository.findById(ticketId).orElseThrow();
        List<Ticket> openTickets = ticketRepository.findByStatus("OPEN");

        for (Ticket other : openTickets) {
            if (!other.getId().equals(base.getId())) {
                DuplicateDetectionLog log =
                        new DuplicateDetectionLog(base, other, 0.8);
                logRepository.save(log);
            }
        }
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}

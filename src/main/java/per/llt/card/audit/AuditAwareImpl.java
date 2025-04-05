package per.llt.card.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    /**
     * Returns the current auditor of the application
     *
     * @return the current auditor
     * We need to integrate with Spring Security current login user is modified the data
     */

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("CARD_MS");
    }
}

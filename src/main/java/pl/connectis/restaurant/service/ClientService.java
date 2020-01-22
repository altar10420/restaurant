package pl.connectis.restaurant.service;

import org.springframework.data.domain.Pageable;
import pl.connectis.restaurant.domain.ClientHibernate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientHibernate createClient(
            String name,
            String surname,
            BigDecimal discount
    );

    Optional<ClientHibernate> getClient(Long id);

    List<ClientHibernate> getAllClient(Pageable pageable);

    List<ClientHibernate> getClientMenuPage(int page);

    void removeClient(Long id);
}
package pl.connectis.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.connectis.restaurant.domain.DrinkHibernate;
import pl.connectis.restaurant.domain.DrinkHibernate;
import pl.connectis.restaurant.repository.DrinkHibernateRepository;
import pl.connectis.restaurant.service.DrinkService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DrinkServiceImpl implements DrinkService {

    private final DrinkHibernateRepository drinkHibernateRepository;

    @Autowired
    public DrinkServiceImpl(DrinkHibernateRepository drinkHibernateRepository) {
        this.drinkHibernateRepository = drinkHibernateRepository;
    }

    @Override
    public Long createDrink(String name,
                           String description,
                           BigDecimal price,
                           Boolean isAvailable,
                           BigDecimal portion_ml) {
        DrinkHibernate drinkHibernate = new DrinkHibernate(
                null,
                name,
                description,
                price,
                isAvailable,
                portion_ml
        );

        drinkHibernateRepository.save(drinkHibernate);
        return drinkHibernate.getId();
    }

    @Override
    public Optional<DrinkHibernate> getDrink(Long id) {
        return drinkHibernateRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<DrinkHibernate> getAllDrinks(Pageable pageable) {
        Page<DrinkHibernate> page = drinkHibernateRepository.findAll(pageable);
        List<DrinkHibernate> hibernates = page.getContent();
        return hibernates.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<DrinkHibernate> getDrinkMenuPage(int page) {
        Page<DrinkHibernate> drinkList = drinkHibernateRepository.findAll(PageRequest.of(page, 10));
        List<DrinkHibernate> hibernates = drinkList.getContent();

        return hibernates.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void removeDrink(Long id) {
        drinkHibernateRepository.deleteById(id);
    }

    public DrinkHibernate toDomain(DrinkHibernate hibernate) {
        return new DrinkHibernate(
                hibernate.getId(),
                hibernate.getName(),
                hibernate.getDescription(),
                hibernate.getPrice(),
                hibernate.getIs_available(),
                hibernate.getPortion_ml()
        );
    }
}
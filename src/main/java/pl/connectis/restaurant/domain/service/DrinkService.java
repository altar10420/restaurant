package pl.connectis.restaurant.domain.service;

import org.springframework.data.domain.Pageable;
import pl.connectis.restaurant.domain.model.Drink;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DrinkService {

    Long createDrink(
            String name,
            String description,
            double price,
            Boolean is_available,
            int portion_ml
    );

    Optional<Drink> getDrink(Long id);

    List<Drink> getAllDrinks(Pageable pageable);

    void removeDrink(Long id);

}
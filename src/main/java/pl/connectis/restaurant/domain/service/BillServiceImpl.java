package pl.connectis.restaurant.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.connectis.restaurant.domain.model.Bill;
import pl.connectis.restaurant.domain.model.Dish;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }


    @Override
    public Long createBill(LocalDateTime date,
                           BigDecimal price,
                           BigDecimal tip,
                           List<Dish> dishes) {
        Bill bill = billRepository.
    }

    @Override
    public Optional<Bill> getBill(Long id) {
        return Optional.empty();
    }
}
package pl.connectis.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.connectis.restaurant.controller.dto.DrinkDTO;
import pl.connectis.restaurant.domain.DrinkHibernate;
import pl.connectis.restaurant.exception.EntityDoesNotExistException;
import pl.connectis.restaurant.service.DrinkService;
import pl.connectis.restaurant.repository.DrinkHibernateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drink")
public class DrinkController {

    private final DrinkService drinkService;
    private final DrinkHibernateRepository drinkHibernateRepository;

    @Autowired
    public DrinkController(DrinkService drinkService, DrinkHibernateRepository drinkHibernateRepository) {
        this.drinkService = drinkService;
        this.drinkHibernateRepository = drinkHibernateRepository;
    }

    @GetMapping(path = "/{id}")
    public DrinkDTO getDrink(@PathVariable("id") Long id) {

        return new DrinkDTO(drinkService.getDrink(id));
    }

    @GetMapping(path = "/menu/{page}/{amountOnPage}")
    public List<DrinkDTO> getDrinksByPage(@PathVariable("page") Integer page,
                                           @PathVariable("amountOnPage") Integer amountOnPage) {
        List<DrinkHibernate> drinkList = drinkService.getDrinksByPage(page, amountOnPage);
        List<DrinkDTO> drinkDTOList = new ArrayList<>();

        for (DrinkHibernate drink : drinkList) {
            drinkDTOList.add(new DrinkDTO(drink));
        }
        return drinkDTOList;
    }

    @PostMapping(path = "/")
    public Long createDrink(@RequestBody DrinkDTO drinkDTO) {
        Long drinkId = drinkService.createDrink(
                drinkDTO.getName(),
                drinkDTO.getDescription(),
                drinkDTO.getPrice(),
                drinkDTO.getAvailable(),
                drinkDTO.getPortion_ml()
        );
        return drinkId;
    }

    @PutMapping("/{id}")
    public void updateDrink(@PathVariable("id") Long id, @RequestBody DrinkDTO drinkDTO) {


        Optional<DrinkHibernate> drinkOptional = drinkHibernateRepository.findById(id);

        if (!drinkOptional.isPresent()) {
            throw new EntityDoesNotExistException();
        }

        drinkService.updateDrink(id,
                drinkDTO.getName(),
                drinkDTO.getDescription(),
                drinkDTO.getPrice(),
                drinkDTO.getAvailable(),
                drinkDTO.getPortion_ml());
    }

    @DeleteMapping(path = "/{id}")
    public void removeDrink(@PathVariable("id") Long id) {

        Optional<DrinkHibernate> drinkOptional = drinkHibernateRepository.findById(id);

        if (!drinkOptional.isPresent()) {
            throw new EntityDoesNotExistException();
        }

        drinkService.removeDrink(id);
    }
}


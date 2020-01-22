package pl.connectis.restaurant.controller.dto;

import pl.connectis.restaurant.domain.DrinkHibernate;

import java.io.Serializable;
import java.math.BigDecimal;

public class DrinkDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Boolean is_available;

    private BigDecimal portion_ml;

    public DrinkDTO() {
    }

    public DrinkDTO(DrinkHibernate drink) {
        this.id = drink.getId();
        this.name = drink.getName();
        this.description = drink.getDescription();
        this.price = drink.getPrice();
        this.is_available = drink.getIs_available();
        this.portion_ml = drink.getPortion_ml();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return is_available;
    }

    public void setAvailable(Boolean available) {
        is_available = available;
    }

    public BigDecimal getPortion_ml() {
        return portion_ml;
    }

    public void setPortion_ml(BigDecimal portion_ml) {
        this.portion_ml = portion_ml;
    }

    public DrinkHibernate toDomain() {
        return new DrinkHibernate(
                id,
                name,
                description,
                price,
                is_available,
                portion_ml
        );
    }
}

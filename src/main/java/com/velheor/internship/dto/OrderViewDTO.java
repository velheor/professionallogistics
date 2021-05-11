package com.velheor.internship.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderViewDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    private LocalDateTime datePickup;

    @NotNull(message = "{notEmpty}")
    private LocalDateTime dateDelivery;

    @NotNull(message = "{notEmpty}")
    @DecimalMin(value = "1", message = "{notCorrectWeight}")
    private BigDecimal price;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 45, message = "{notCorrectSize}")
    private String truckCategory;

    public OrderViewDTO(OrderViewDTO orderViewDTO){
        super.setId(orderViewDTO.getId());
        datePickup = orderViewDTO.getDatePickup();
        dateDelivery = orderViewDTO.getDateDelivery();
        price = orderViewDTO.getPrice();
        truckCategory = orderViewDTO.getTruckCategory();
    }
}

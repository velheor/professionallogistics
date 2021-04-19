package com.velheor.internship.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderViewDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    private LocalDateTime datePickup;

    @NotNull(message = "{notEmpty}")
    private LocalDateTime dateDelivery;

    @NotNull(message = "{notEmpty}")
    private BigDecimal price;

    @NotNull(message = "{notEmpty}")
    @Size(min = 2, max = 45, message = "{notCorrectSize}")
    private String truckCategory;
}

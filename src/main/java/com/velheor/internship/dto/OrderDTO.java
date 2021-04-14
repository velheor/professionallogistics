package com.velheor.internship.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO extends BaseDTO {

    @NotNull(message = "{datePickup.notEmpty}")
    private LocalDateTime datePickup;

    @NotNull(message = "{dateDelivery.notEmpty}")
    private LocalDateTime dateDelivery;

    @NotNull(message = "{price.notEmpty}")
    private BigDecimal price;

    private String voucherPickup;

    private String voucherDelivery;

    @NotNull(message = "{truckCategory.notEmpty}")
    private String truckCategory;
}

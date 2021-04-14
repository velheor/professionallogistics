package com.velheor.internship.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    private LocalDateTime datePickup;

    @NotNull(message = "{notEmpty}")
    private LocalDateTime dateDelivery;

    @NotNull(message = "{notEmpty}")
    private BigDecimal price;

    private String voucherPickup;

    private String voucherDelivery;

    @NotNull(message = "{notEmpty}")
    private String truckCategory;
}

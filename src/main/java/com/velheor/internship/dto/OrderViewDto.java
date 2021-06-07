package com.velheor.internship.dto;

import com.velheor.internship.xml.LocalDateTimeAdapter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "Order")
public class OrderViewDto extends BaseDto {

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

    public OrderViewDto(OrderViewDto orderViewDTO) {
        super.setId(orderViewDTO.getId());
        datePickup = orderViewDTO.getDatePickup();
        dateDelivery = orderViewDTO.getDateDelivery();
        price = orderViewDTO.getPrice();
        truckCategory = orderViewDTO.getTruckCategory();
    }

    @XmlElement(name = "date_pickup")
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getDatePickup() {
        return datePickup;
    }

    @XmlElement(name = "date_delivery")
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getDateDelivery() {
        return dateDelivery;
    }

    @XmlElement(name = "truck_category")
    public String getTruckCategory() {
        return truckCategory;
    }
}

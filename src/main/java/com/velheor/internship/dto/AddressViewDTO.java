package com.velheor.internship.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AddressViewDTO extends BaseDTO {

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 20, message = "{notCorrectSize}")
    private String country;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 25, message = "{notCorrectSize}")
    private String city;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 25, message = "{notCorrectSize}")
    private String streetName;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 10, message = "{notCorrectSize}")
    private String streetNumber;

    public AddressViewDTO(AddressViewDTO addressViewDTO){
        super.setId(addressViewDTO.getId());
        country = addressViewDTO.getCountry();
        city = addressViewDTO.getCity();
        streetName = addressViewDTO.getStreetName();
        streetNumber = addressViewDTO.getStreetNumber();
    }
}

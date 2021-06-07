package com.velheor.internship.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "User")
public class UserViewDto extends BaseDto {

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 15, message = "{notCorrectSize}")
    private String firstName;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 15, message = "{notCorrectSize}")
    private String lastName;

    @NotEmpty(message = "{notEmpty}")
    @Email(message = "{notValidEmail}")
    @Size(max = 255, message = "{notCorrectSize}")
    private String email;

    @NotEmpty(message = "{notEmpty}")
    @Pattern(regexp = "^\\+375 \\((17|29|33|44)\\) [0-9]{3}-[0-9]{2}-[0-9]{2}$", message = "{notValidPhoneNumber}")
    private String phoneNumber;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 7, max = 255, message = "{notCorrectSize}")
    private String password;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 3, max = 15, message = "{notCorrectSize}")
    private String status;

    public UserViewDto(UserViewDto userViewDTO) {
        super.setId(userViewDTO.getId());
        firstName = userViewDTO.getFirstName();
        lastName = userViewDTO.getLastName();
        email = userViewDTO.getEmail();
        phoneNumber = userViewDTO.getPhoneNumber();
        password = userViewDTO.getPassword();
        status = userViewDTO.getStatus();
    }

    @XmlElement(name = "first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }
}

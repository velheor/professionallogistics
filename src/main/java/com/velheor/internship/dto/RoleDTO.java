package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoleDTO {

    @NotNull(message = "notEmpty")
    private String name;
}

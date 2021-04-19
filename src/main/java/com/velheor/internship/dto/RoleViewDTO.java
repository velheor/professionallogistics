package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoleViewDTO {

    @NotNull(message = "{notEmpty}")
    private String name;
}

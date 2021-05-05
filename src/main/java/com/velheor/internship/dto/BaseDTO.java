package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class BaseDTO {

    @NotNull(message = "{notEmpty}")
    private UUID id;
}

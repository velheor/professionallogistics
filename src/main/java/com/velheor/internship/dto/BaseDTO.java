package com.velheor.internship.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BaseDTO {

    @NotNull(message = "{notEmpty}")
    private UUID id;
}

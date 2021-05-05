package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class StatusViewDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    @Size(min = 10, max = 255, message = "{notCorrectSize}")
    private String name;

    @NotNull(message = "{notEmpty}")
    private LocalDateTime statusDate;
}

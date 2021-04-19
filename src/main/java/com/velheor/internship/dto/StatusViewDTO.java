package com.velheor.internship.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class StatusViewDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    @Size(min = 10, max = 255, message = "{notCorrectSize}")
    private String name;

    @NotNull(message = "{notEmpty}")
    private LocalDateTime statusDate;
}

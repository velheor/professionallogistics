package com.velheor.internship.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StatusViewDTO extends BaseDTO {

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 10, max = 255, message = "{notCorrectSize}")
    private String name;

    @NotNull(message = "{notEmpty}")
    private LocalDateTime statusDate;

    public StatusViewDTO(StatusViewDTO statusViewDTO1){
        super.setId(statusViewDTO1.getId());
        name = statusViewDTO1.getName();
        statusDate = statusViewDTO1.getStatusDate();
    }
}

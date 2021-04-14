package com.velheor.internship.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class StatusDTO extends BaseDTO {

    private String name;

    private LocalDateTime statusDate;
}

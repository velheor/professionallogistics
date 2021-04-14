package com.velheor.internship.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusDTO extends BaseDTO {

    private String name;

    private LocalDateTime statusDate;
}

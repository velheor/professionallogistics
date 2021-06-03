package com.velheor.internship.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class RoleViewDto extends BaseDto {

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 45, message = "{notCorrectSize}")
    private String name;

    public RoleViewDto(RoleViewDto roleViewDTO) {
        super.setId(roleViewDTO.getId());
        name = roleViewDTO.getName();
    }
}

package com.velheor.internship.service.specification;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpecificationDiapason {
    Object left;
    Object right;
    String keyLeft;
    String keyRight;
    SearchOperation operationLeft;
    SearchOperation operationRight;
    SearchOperation combine;
}

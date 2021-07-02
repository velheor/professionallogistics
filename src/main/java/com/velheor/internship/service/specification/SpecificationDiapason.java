package com.velheor.internship.service.specification;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpecificationDiapason {
    private final SearchCriteria searchCriteriaLeft;
    private final SearchCriteria searchCriteriaRight;
    SearchOperation combine;
}

package com.velheor.internship.service.specification.utils;

import com.velheor.internship.service.specification.GenericSpecification;
import com.velheor.internship.service.specification.SearchCriteria;
import com.velheor.internship.service.specification.SpecificationDiapason;
import org.springframework.data.jpa.domain.Specification;

import static com.velheor.internship.service.specification.SearchOperation.OR;

public class SpecificationUtil {

    public static <T> Specification<T> prepareDiapason(SpecificationDiapason specificationDiapason) {
        Specification<T> specification = (root, query, criteriaBuilder) -> null;

        if (specificationDiapason.getSearchCriteriaLeft().getValue() != null) {
            specification = new GenericSpecification<>(specificationDiapason.getSearchCriteriaLeft());
        }

        if (specificationDiapason.getSearchCriteriaRight().getValue() != null) {
            GenericSpecification<T> specificationRight = new GenericSpecification<>(specificationDiapason.getSearchCriteriaRight());
            if (specificationDiapason.getCombine().equals(OR)) {
                specification = specification.or(specificationRight);
            } else {
                specification = specification.and(specificationRight);
            }
        }
        return specification;
    }
}

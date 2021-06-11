package com.velheor.internship.service.specification.utils;

import com.velheor.internship.service.specification.GenericSpecification;
import com.velheor.internship.service.specification.SearchCriteria;
import com.velheor.internship.service.specification.SpecificationDiapason;
import org.springframework.data.jpa.domain.Specification;

import static com.velheor.internship.service.specification.SearchOperation.OR;

public class CommonSpec {
    public static <T> Specification<T> prepareSpecification(SpecificationDiapason specificationDiapason) {
        Specification<T> specification = null;

        if (specificationDiapason.getLeft() != null) {
            SearchCriteria searchCriteria = new SearchCriteria(specificationDiapason.getKeyLeft(),
                    specificationDiapason.getLeft(), specificationDiapason.getOperationLeft());
            specification = new GenericSpecification<>(searchCriteria);
        }
        if (specificationDiapason.getRight() != null) {
            SearchCriteria searchCriteria = new SearchCriteria(specificationDiapason.getKeyLeft(),
                    specificationDiapason.getRight(), specificationDiapason.getOperationRight());
            GenericSpecification<T> specificationRight = new GenericSpecification<>(searchCriteria);
            if (specification == null) {
                specification = specificationRight;
            } else {
                if (specificationDiapason.getCombine().equals(OR)) {
                    specification = specification.or(specificationRight);
                } else {
                    specification = specification.and(specificationRight);
                }
            }
        }
        return specification;
    }
}

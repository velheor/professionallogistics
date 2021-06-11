package com.velheor.internship.service.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class GenericSpecification<T> implements Specification<T> {
    private final SearchCriteria searchCriteria;

    @Override
    public Specification<T> and(Specification<T> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<T> or(Specification<T> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        switch (searchCriteria.getOperation()) {
            case GREATER_THAN:
                return builder.greaterThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
            case LESS_THAN:
                return builder.lessThan(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
            default:
                throw new IllegalArgumentException("Search operation doesn't set or exist!") ;
        }
    }
}

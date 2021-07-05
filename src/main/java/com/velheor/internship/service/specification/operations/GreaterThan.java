package com.velheor.internship.service.specification.operations;

import com.velheor.internship.service.specification.PredicateBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;

public class GreaterThan implements PredicateBuilder {

    @Override
    public Predicate getPredicate(CriteriaBuilder builder, Object value, Path path) {
        if (value instanceof LocalDateTime) {
            return builder.greaterThan(path, (LocalDateTime) value);
        }
        return builder.greaterThan(path, value.toString());
    }
}

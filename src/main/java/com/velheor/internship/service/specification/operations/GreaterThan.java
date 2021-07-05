package com.velheor.internship.service.specification.operations;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.Objects;

public class GreaterThan implements PredicateBuilder {

    @Override
    public Predicate getPredicate(CriteriaBuilder builder, Object value, Path path) {

        if (Objects.isNull(value)) {
            return builder.and();
        }

        if (value instanceof LocalDateTime) {
            return builder.greaterThan(path, (LocalDateTime) value);
        }
        return builder.greaterThan(path, value.toString());
    }
}

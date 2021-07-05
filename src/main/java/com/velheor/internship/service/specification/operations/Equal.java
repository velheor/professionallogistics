package com.velheor.internship.service.specification.operations;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Objects;

public class Equal implements PredicateBuilder {

    @Override
    public Predicate getPredicate(CriteriaBuilder builder, Object value, Path path) {

        if (Objects.isNull(value)) {
            return builder.and();
        }

        return builder.equal(path, value);
    }
}

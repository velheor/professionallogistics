package com.velheor.internship.service.specification.operations;

import com.velheor.internship.service.specification.PredicateBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class Equal implements PredicateBuilder {

    @Override
    public Predicate getPredicate(CriteriaBuilder builder, Object value, Path path) {
        return builder.equal(path, value);
    }
}

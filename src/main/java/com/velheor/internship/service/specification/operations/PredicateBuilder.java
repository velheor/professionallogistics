package com.velheor.internship.service.specification.operations;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public interface PredicateBuilder {

    Predicate getPredicate(CriteriaBuilder builder, Object value, Path path);
}

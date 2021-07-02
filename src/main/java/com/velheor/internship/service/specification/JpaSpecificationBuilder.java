package com.velheor.internship.service.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JpaSpecificationBuilder<T> {

    private final Map<String, Join<Object, Object>> joinMap = new HashMap<>();

    public Specification<T> buildSpecification(SearchCriteria criteria) {
        this.joinMap.clear();
        return (root, query, cb) -> toPredicate(root, cb, criteria);
    }

    public Predicate toPredicate(Root<T> root, CriteriaBuilder builder, SearchCriteria criteria) {
        if (criteria.isComplex()) {
            List<Predicate> predicates = new ArrayList<>();
            for (SearchCriteria subCriterion : criteria.getCriteria()) {
                predicates.add(toPredicate(root, builder, subCriterion));
            }
            if (SearchOperation.AND.equals(criteria.getOperation())) {
                return builder.and(predicates.toArray(new Predicate[0]));
            } else {
                return builder.or(predicates.toArray(new Predicate[0]));
            }
        }
        return predicateBuilder(root, builder, criteria);
    }

    public Predicate predicateBuilder(Root<T> root, CriteriaBuilder builder, SearchCriteria searchCriteria) {
        if (searchCriteria.getValue() instanceof LocalDateTime) {
            switch (searchCriteria.getOperation()) {
                case GREATER_THAN:
                    return builder.greaterThan(buildPath(root, searchCriteria.getKey()), (LocalDateTime) searchCriteria.getValue());
                case LESS_THAN:
                    return builder.lessThan(buildPath(root, searchCriteria.getKey()), (LocalDateTime) searchCriteria.getValue());
            }
        }

        switch (searchCriteria.getOperation()) {
            case GREATER_THAN:
                return builder.greaterThan(buildPath(root, searchCriteria.getKey()), searchCriteria.getValue().toString());
            case LESS_THAN:
                return builder.lessThan(buildPath(root, searchCriteria.getKey()), searchCriteria.getValue().toString());
            case EQUALS:
                return builder.equal(buildPath(root, searchCriteria.getKey()), searchCriteria.getValue());
            default:
                throw new IllegalArgumentException("Search operation doesn't set or exist!");
        }
    }

    private Path buildPath(Root<T> root, String key) {

        if (!key.contains(".")) {
            return root.get(key);
        } else {
            String[] path = key.split("\\.");

            String subPath = path[0];

            joinMap.put(subPath, root.join(subPath));

            for (int i = 0; i < path.length - 1; i++) {
                subPath = Stream.of(path).limit(i + 1).collect(Collectors.joining("."));
                if (joinMap.get(subPath) == null) {
                    String prevPath = Stream.of(path).limit(i).collect(Collectors.joining("."));
                    joinMap.put(subPath, joinMap.get(prevPath).join(path[i]));
                }
            }

            return joinMap.get(subPath).get(path[path.length - 1]);
        }
    }
}

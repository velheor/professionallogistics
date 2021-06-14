package com.velheor.internship.service.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                return builder.greaterThan(buildPath(root, searchCriteria.getKey()), searchCriteria.getValue().toString());
            case LESS_THAN:
                return builder.lessThan(buildPath(root, searchCriteria.getKey()), searchCriteria.getValue().toString());
            case EQUALS:
                return builder.equal(buildPath(root, searchCriteria.getKey()), searchCriteria.getValue().toString());
            default:
                throw new IllegalArgumentException("Search operation doesn't set or exist!");
        }
    }

    private Path buildPath(Root<T> root, String key) {
        Map<String, Join<Object, Object>> joinMap = new HashMap<>();

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

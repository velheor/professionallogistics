package com.velheor.internship.service.specification;

import com.velheor.internship.service.specification.operations.Equal;
import com.velheor.internship.service.specification.operations.GreaterThan;
import com.velheor.internship.service.specification.operations.LessThan;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JpaSpecificationBuilder<T> {

    private final Map<String, Join<Object, Object>> joinMap = new HashMap<>();

    private final Map<SearchOperation, PredicateBuilder> predicateBuilders = Stream.of(
            new AbstractMap.SimpleEntry<SearchOperation, PredicateBuilder>(SearchOperation.EQUALS, new Equal()),
            new AbstractMap.SimpleEntry<SearchOperation, PredicateBuilder>(SearchOperation.GREATER_THAN, new GreaterThan()),
            new AbstractMap.SimpleEntry<SearchOperation, PredicateBuilder>(SearchOperation.LESS_THAN, new LessThan())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

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
            if (JoinType.AND.equals(criteria.getJoinType())) {
                return builder.and(predicates.toArray(new Predicate[0]));
            } else {
                return builder.or(predicates.toArray(new Predicate[0]));
            }
        }
        return predicateBuilders.get(criteria.getOperation()).getPredicate(builder, criteria.getValue(), buildPath(root, criteria.getKey()));
    }

    private Path buildPath(Root<T> root, String key) {

        if (!key.contains(".")) {
            return root.get(key);
        } else {
            String[] path = key.split("\\.");

            String subpath = path[0];
            if (joinMap.get(subpath) == null) {
                joinMap.put(subpath, root.join(subpath));
            }
            for (int i = 0; i < path.length - 1; i++) {
                subpath = Stream.of(path).limit(i + 1).collect(Collectors.joining("."));
                if (joinMap.get(subpath) == null) {
                    String prevPath = Stream.of(path).limit(i).collect(Collectors.joining("."));
                    joinMap.put(subpath, joinMap.get(prevPath).join(path[i]));
                }
            }

            return joinMap.get(subpath).get(path[path.length - 1]);
        }
    }
}

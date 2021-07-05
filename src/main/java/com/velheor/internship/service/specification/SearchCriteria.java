package com.velheor.internship.service.specification;

import io.jsonwebtoken.lang.Collections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private Object value;
    private SearchOperation operation;
    private List<SearchCriteria> criteria;
    private JoinType joinType;

    public boolean isComplex() {
        return !Objects.isNull(joinType) && !Collections.isEmpty(criteria);
    }
}

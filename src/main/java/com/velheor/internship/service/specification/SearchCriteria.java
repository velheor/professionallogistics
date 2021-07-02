package com.velheor.internship.service.specification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private Object value;
    private SearchOperation operation;
    private List<SearchCriteria> criteria;

    public boolean isComplex(){
        return this.operation != null && this.criteria != null && this.criteria.size() > 0;
    }
}

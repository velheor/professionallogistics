package com.velheor.internship.models;

import com.velheor.internship.models.enums.SearchOperation;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpecificationFilter {
    Object left;
    Object right;
    String fieldNameLeft;
    String fieldNameRight;
    SearchOperation operationLeft;
    SearchOperation operationRight;
    SearchOperation combine;
}

package com.velheor.internship.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.velheor.internship.mappers.CustomDateSerializer;
import com.velheor.internship.mappers.RateDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "currencies")
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(
        name = "CurrencyWithRates",
        attributeNodes = {
                @NamedAttributeNode(value = "rates")
        }
)
public class Currency extends BaseEntity {

    @JsonProperty(value = "base")
    private String name;

    @JsonProperty(value = "timestamp")
    @JsonDeserialize(using = CustomDateSerializer.class)
    private LocalDateTime updated;

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL)
    @JsonProperty(value = "rates")
    @JsonDeserialize(using = RateDeserializer.class)
    private List<Rate> rates;
}

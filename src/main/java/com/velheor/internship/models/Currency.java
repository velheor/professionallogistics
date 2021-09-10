package com.velheor.internship.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.velheor.internship.mappers.RateDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Currency {

    @Id
    @JsonProperty(value = "base")
    @Column(name = "id")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL)
    @JsonProperty(value = "results")
    @JsonDeserialize(using = RateDeserializer.class)
    private List<Rate> rates;
}

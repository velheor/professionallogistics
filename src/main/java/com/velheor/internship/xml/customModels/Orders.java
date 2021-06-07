package com.velheor.internship.xml.customModels;

import com.velheor.internship.dto.OrderViewDto;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "Orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders {
    @XmlElement(name = "Order")
    private List<OrderViewDto> orders;
}

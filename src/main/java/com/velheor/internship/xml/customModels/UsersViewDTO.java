package com.velheor.internship.xml.customModels;

import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.models.User;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Users")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class UsersViewDTO {
    @XmlElement(name = "User")
    private List<UserViewDTO> users;
}
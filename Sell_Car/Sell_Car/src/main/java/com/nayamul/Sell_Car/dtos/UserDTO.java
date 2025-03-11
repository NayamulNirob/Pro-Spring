package com.nayamul.Sell_Car.dtos;

import com.nayamul.Sell_Car.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private long id;
    private String name;
    private String email;
    private UserRole userRole;

    public UserDTO(long id, String name, String email, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userRole = userRole;
    }


}

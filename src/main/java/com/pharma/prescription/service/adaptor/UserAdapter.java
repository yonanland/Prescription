package com.pharma.prescription.service.adaptor;

import com.pharma.prescription.model.User;
import com.pharma.prescription.service.dto.UserDTO;

public class UserAdapter {

    public static User toUser(UserDTO userDTO){
        return new User(userDTO.id(),
                userDTO.username(),
                userDTO.password(),
                userDTO.role());
    }


    public static UserDTO toUserDTO(User user){
        return new UserDTO(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }
}

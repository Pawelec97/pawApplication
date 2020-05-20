package pl.pawelec97.pawApplication.model.DTO;

import lombok.Data;


@Data
public class UserDto {
    int id;
    String name;
    String password;
    String email;

}

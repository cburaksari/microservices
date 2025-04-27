package user.service.demo.models.dto;

import lombok.Data;
import user.service.demo.models.Role;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
}

package user.service.demo.models.dto;

import lombok.Data;

@Data
public class UserRegistrationDTO {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
}

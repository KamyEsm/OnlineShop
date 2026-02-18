package org.example.onlineshop.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RegisterEmployeeDTO {
    @NotBlank(message = "This field cannot be empty.")
    @Size(min = 2, max = 50, message = "The length of this field must be between 2 and 50.")
    private String firstName;
    @NotBlank(message = "This field cannot be empty.")
    @Size(min = 2, max = 50, message = "The length of this field must be between 2 and 50.")
    private String lastName;
    @Pattern(regexp = "09\\d{9}" , message = "This phone number is incorrect.")
    private String phoneNumber;
    @NotBlank(message = "This field cannot be empty.")
    @Size(min = 2, max = 50 , message = "The length of this field must be between 2 and 50.")
    private String username;
    @NotBlank(message = "This field cannot be empty.")
    @Size(min = 8, max = 50,message = "The password length must be between 8 and 50.")
    private String password;
}

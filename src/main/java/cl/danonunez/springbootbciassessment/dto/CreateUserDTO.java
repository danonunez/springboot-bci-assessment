package cl.danonunez.springbootbciassessment.dto;

import cl.danonunez.springbootbciassessment.validation.ValidEmail;
import cl.danonunez.springbootbciassessment.validation.ValidPassword;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {

    @NotBlank
    private String name;

    @NotBlank
    @ValidEmail(message = "{email.message}")
    private String email;

    @NotBlank
    @ValidPassword(message = "{password.message}")
    private String password;

    @Valid
    @NotNull
    private List<PhoneDTO> phones;
}

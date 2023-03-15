package cl.danonunez.springbootbciassessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatedUserDTO {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones;
    private Date created;
    private Date modified;
    @JsonProperty(value = "last_login", access = JsonProperty.Access.READ_ONLY)
    private Date lastLogin;
    private String token;
    @JsonProperty(value = "isactive", access = JsonProperty.Access.READ_ONLY)
    private Boolean isActive;
}

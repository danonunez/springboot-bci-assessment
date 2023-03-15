package cl.danonunez.springbootbciassessment.dto;

import cl.danonunez.springbootbciassessment.validation.ValidInteger;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

    @NotBlank
    @ValidInteger
    private String number;

    @NotBlank
    @ValidInteger
    @JsonProperty(value = "citycode")
    private String cityCode;

    @NotBlank
    @ValidInteger
    @JsonProperty(value = "contrycode")
    private String contryCode;
}

package cl.danonunez.springbootbciassessment.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidIntegerValidator.class)
public @interface ValidInteger {

    String message() default "debe ser un numero entero";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

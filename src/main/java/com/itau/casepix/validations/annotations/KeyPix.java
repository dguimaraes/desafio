package com.itau.casepix.validations.annotations;

import com.itau.casepix.validations.KeyPixValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {KeyPixValidator.class})
@Documented
public @interface KeyPix {

    String message() default "{KeyPix.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

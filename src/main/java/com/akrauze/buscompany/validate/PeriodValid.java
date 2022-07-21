package com.akrauze.buscompany.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PeriodValidator. class)
@Target( { ElementType. METHOD, ElementType. FIELD })
@Retention(RetentionPolicy. RUNTIME)
public @interface PeriodValid {
    String message() default "VALUE_IS_NOT_CORRECT";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package meow.pasyagitka.findtrainingvideos.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "{Password}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

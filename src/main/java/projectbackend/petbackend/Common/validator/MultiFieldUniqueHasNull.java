package projectbackend.petbackend.Common.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = MultiFieldUniqueHasNullValidator.class)
public @interface MultiFieldUniqueHasNull {

    String messages() default "{common.unique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class clazz();

    String uniqueFields() default "";

    String idField() default "";
}

package meow.pasyagitka.findtrainingvideos.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public void initialize(Password paramA) {
    }
    @Override
    public boolean isValid(String password, ConstraintValidatorContext ctx) {
        if(password == null){
            return false;
        }
        return password.matches("^(?=.*[0-9])(?=.*[a-z]).{4,500}$");
        //#start-of-string
        //(?=.*[0-9])       # a digit must occur at least once
        //(?=.*[a-z])       # a lower case letter must occur at least once
    }
}

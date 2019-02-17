package app.validator;

import app.entities.User;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.userForm.confirmPassword");
//
//        if (user.getCountry().equalsIgnoreCase("none")){
//            errors.rejectValue("country", "NotEmpty.userForm.country");
//        }
//
//        if (!user.getPassword().equals(user.getConfirmPassword())){
//            errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
//        }
    }
}

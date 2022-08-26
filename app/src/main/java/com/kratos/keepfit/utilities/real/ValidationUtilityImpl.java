package com.kratos.keepfit.utilities.real;

import com.kratos.keepfit.utilities.interfaces.ValidationUtility;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

/** Validation utility implementation class. */
public class ValidationUtilityImpl implements ValidationUtility {

    /** Constructs a new instance. */
    @Inject
    public ValidationUtilityImpl() {

    }


    @Override
    public boolean isNotValidEmail(String email) {
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    @Override
    public boolean isNotValidPassword(String password) {
        return password == null || password.trim().isEmpty();
    }

    @Override
    public boolean isNotValidEmailCode(String emailCode) {
        return !emailCode.matches("[0-9]+");
    }
}
package com.kratos.keepfit.utilities.fakes;

import com.kratos.keepfit.utilities.interfaces.ValidationUtility;

import javax.inject.Inject;

/** Fake ValidationUtility implementation class. */
public class FakeValidationUtility implements ValidationUtility {

    /** Constructs a new instance. */
    @Inject
    public FakeValidationUtility() {

    }

    @Override
    public boolean isNotValidEmail(String email) {
        return false;
    }

    @Override
    public boolean isNotValidPassword(String password) {
        return false;
    }

    @Override
    public boolean isNotValidEmailCode(String emailCode) {
        return false;
    }
}

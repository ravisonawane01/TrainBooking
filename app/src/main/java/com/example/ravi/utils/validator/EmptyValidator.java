package com.example.ravi.utils.validator;

/**
 * Created by Ravi on 4/20/2018.
 */
public class EmptyValidator extends DataValidator {
    public EmptyValidator(Validator validator) {
        super(validator);
    }

    @Override
    public boolean validate(String data) {
        if (data == null || data.trim().length() == 0) {
            return validator.validate(data) && false;
        } else {
            return validator.validate(data) && true;
        }
    }
}

package com.example.ravi.utils.validator;

/**
 * Created by Ravi on 4/20/2018.
 */
public class DataValidator implements Validator {

    Validator validator;
    public DataValidator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean validate(String data) {
        return validator.validate(data);
    }
}

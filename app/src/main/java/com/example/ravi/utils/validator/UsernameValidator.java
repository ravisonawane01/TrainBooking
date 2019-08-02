package com.example.ravi.utils.validator;


import com.example.ravi.utils.Util;

/**
 * Created by Ravi on 4/20/2018.
 */
public class UsernameValidator extends DataValidator {
    private String PLAIN_TEXT_PATTERN = "^[a-zA-Z0-9)(\\-._& ]+$";

    public UsernameValidator(Validator validator) {
        super(validator);
    }

    @Override
    public boolean validate(String data) {
        return validator.validate(data) && Util.applyRegex(PLAIN_TEXT_PATTERN, data);
    }
}

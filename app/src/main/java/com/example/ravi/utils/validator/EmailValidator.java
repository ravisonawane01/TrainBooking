package com.example.ravi.utils.validator;


import com.example.ravi.utils.Util;

/**
 * Created by Ravi on 4/20/2018.
 */
public class EmailValidator extends DataValidator {

    private String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator(Validator validator) {
        super(validator);
    }

    @Override
    public boolean validate(String data) {
        return validator.validate(data) && Util.applyRegex(EMAIL_PATTERN, data);
    }
}

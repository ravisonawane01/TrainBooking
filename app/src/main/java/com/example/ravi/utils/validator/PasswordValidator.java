package com.example.ravi.utils.validator;


import com.example.ravi.utils.Util;

/**
 * Created by Ravi on 4/20/2018.
 */
public class PasswordValidator extends DataValidator{

//    private String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{8,40})";
    private String PASSWORD_PATTERN = "^((?=.+\\d).{8,16})$";

    public PasswordValidator(Validator validator) {
        super(validator);
    }

    @Override
    public boolean validate(String data) {
        return validator.validate(data) && Util.applyRegex(PASSWORD_PATTERN, data);
    }
}

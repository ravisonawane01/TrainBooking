package com.example.ravi.utils.validator;

import com.example.ravi.utils.Util;

/**
 * Created by Ravi on 4/20/2018.
 */
public class UKPostCodeValidator extends DataValidator {

    private String POST_CODE_PATTERN = "^(([gG][iI][rR] {0,}0[aA]{2})|((([a-pr-uwyzA-PR-UWYZ][a-hk-yA-HK-Y]?[0-9][0-9]?)|(([a-pr-uwyzA-PR-UWYZ][0-9][a-hjkstuwA-HJKSTUW])|([a-pr-uwyzA-PR-UWYZ][a-hk-yA-HK-Y][0-9][abehmnprv-yABEHMNPRV-Y]))) {0,}[0-9][abd-hjlnp-uw-zABD-HJLNP-UW-Z]{2}))$";

    public UKPostCodeValidator(Validator validator) {
        super(validator);
    }

    @Override
    public boolean validate(String data) {
        return validator.validate(data) && Util.applyRegex(POST_CODE_PATTERN, data);
    }
}

package com.syx.bytcrm.validator.constraints.validator;

import com.syx.bytcrm.validator.constraints.Sex;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 牛东峰
 */
public class SexValidator implements ConstraintValidator<Sex, String> {

    private static final String MALE   = "男";
    private static final String FEMALE = "女";

    @Override
    public void initialize(Sex constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return MALE.equals(value) || FEMALE.equals(value);
    }

}

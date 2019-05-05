package com.syx.bytcrm.validator.util;

import com.syx.bytcrm.exp.ParameterFormatException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Optional;
import java.util.Set;

/**
 * @author 牛东峰
 */
public class ValidatorUtil {

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static void validate(Object object, Class<?>... groups) throws IllegalArgumentException, ParameterFormatException {

        Optional.ofNullable(object).orElseThrow(() -> new ParameterFormatException("请求参数不能为空"));

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new IllegalArgumentException(constraintViolations.iterator().next().getMessage());
        }

    }

}

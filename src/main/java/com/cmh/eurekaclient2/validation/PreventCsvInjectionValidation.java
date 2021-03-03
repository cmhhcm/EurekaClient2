package com.cmh.eurekaclient2.validation;

import com.cmh.eurekaclient2.annotation.PreventCsvInjection;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Slf4j
public class PreventCsvInjectionValidation implements ConstraintValidator<PreventCsvInjection, String> {
    @Override
    public void initialize(PreventCsvInjection constraintAnnotation) {
        log.info("entered self init method ..");

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        log.info("start to isValid method");
        String regex = "^(@|=|-|_|\\+).*$";
        if (StringUtils.isNotEmpty(s) && Pattern.matches(regex, s)) {
            return false;
        } else {
            return true;
        }
    }
}

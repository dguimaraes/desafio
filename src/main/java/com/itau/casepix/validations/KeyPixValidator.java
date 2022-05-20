package com.itau.casepix.validations;

import com.itau.casepix.dtos.request.KeyPixPostDto;
import com.itau.casepix.validations.annotations.KeyPix;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class KeyPixValidator implements ConstraintValidator<KeyPix, KeyPixPostDto> {

    @Override
    public boolean isValid(KeyPixPostDto value, ConstraintValidatorContext context) {
        return value.getKeyType().executeRule(value.getKeyValue());
    }
}

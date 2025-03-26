package com.karzhou.bus.validator;

import com.karzhou.bus.entity.Bus;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Map;
import java.util.stream.Collectors;

public interface BusValidator {
    static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    static final Validator validator = factory.getValidator();

    default Map<String, Boolean> validateAttributes(Bus bus) {
        return validator.validate(bus).stream()
                .collect(Collectors.toMap(
                        v->v.getPropertyPath().toString(),
                        v->false,
                        (existing, replacement) ->existing
                ));
    }
}

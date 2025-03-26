package com.karzhou.bus.validator.impl;

import com.karzhou.bus.entity.Bus;
import com.karzhou.bus.validator.BusValidator;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Map;
import java.util.stream.Collectors;

public class BusValidatorImpl implements BusValidator {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    @Override
    public Map<String, Boolean> validateAttributes(Bus bus) {
        return validator.validate(bus).stream()
                .collect(Collectors.toMap(
                        v -> v.getPropertyPath().toString(),
                        v -> false,
                        (existing, replacement) -> existing
                ));
    }
}

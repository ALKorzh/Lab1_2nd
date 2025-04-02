package com.karzhou.bus.validator;

import com.karzhou.bus.entity.Bus;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Map;
import java.util.stream.Collectors;

public interface BusValidator {
    Map<String, Boolean> validateAttributes(Bus bus);
}

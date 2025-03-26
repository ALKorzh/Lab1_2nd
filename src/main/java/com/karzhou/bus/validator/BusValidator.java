package com.karzhou.bus.validator;

import com.karzhou.bus.entity.Bus;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public interface BusValidator {
    static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    static final Validator validator = factory.getValidator();
    static final Logger logger = LogManager.getLogger(BusValidator.class);

    public default void validate(Object object) {
        logger.info("Starting validation: {}", object);

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        if(!constraintViolations.isEmpty()){
            StringBuilder errorMessage = new StringBuilder("Validation Failed: ");
            for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
                errorMessage.append(constraintViolation.getMessage());
                logger.warn("Validation error: {}", constraintViolation.getMessage());
            }
            logger.error("Validation failed with errors: {}", errorMessage);
            throw new IllegalArgumentException(errorMessage.toString());
        }
        logger.info("Validation successful: {}", object);
    }

    void validate(Bus bus);
}

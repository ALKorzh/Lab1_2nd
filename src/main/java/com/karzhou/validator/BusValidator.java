package com.karzhou.validator;

import com.karzhou.entity.Bus;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class BusValidator {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    private static Logger logger = LogManager.getLogger(BusValidator.class);

    public void validate(Bus bus) {
        logger.info("Starting validation for bus: {}", bus);

        Set<ConstraintViolation<Bus>> constraintViolations = validator.validate(bus);
        if(!constraintViolations.isEmpty()){
            StringBuilder errorMessage = new StringBuilder("Validation Failed: ");
            for (ConstraintViolation<Bus> constraintViolation : constraintViolations) {
                errorMessage.append(constraintViolation.getMessage());
                logger.warn("Validation error: {}", constraintViolation.getMessage());
            }
            logger.error("Validation failed with errors: {}", errorMessage);
            throw new IllegalArgumentException(errorMessage.toString());
        }
        logger.info("Validation successful for bus: {}", bus);
    }
}

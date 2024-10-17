package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid;
        boolean belowMin;
        boolean aboveMax;
        belowMin = part.getInv() < part.getMinInv();
        aboveMax = part.getInv() > part.getMaxInv();
        constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory is out of range").addPropertyNode("inv").addConstraintViolation();
        if(belowMin || aboveMax){
            isValid = false;
        } else {
            isValid = true;
        }
        return isValid;
    }
}



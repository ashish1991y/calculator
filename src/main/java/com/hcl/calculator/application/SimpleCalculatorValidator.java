package com.hcl.calculator.application;

import org.springframework.stereotype.Service;

@Service
public class SimpleCalculatorValidator {

    public boolean isZero(Double value)
    {
      return value.equals(Double.valueOf(0));
    }
}

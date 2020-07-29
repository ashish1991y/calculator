package com.hcl.calculator.application;

import org.springframework.stereotype.Service;

@Service
public interface SimpleCalculatorService {
    public double performOperation(SimpleCalculatorDTO simpleCalculatorDTO);
}

package com.hcl.calculator.application;

import com.hcl.calculator.exception.SimpleCalculatorException;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculatorServiceImpl implements SimpleCalculatorService {
    private SimpleCalculatorValidator simpleCalculatorValidator;

    public SimpleCalculatorServiceImpl(SimpleCalculatorValidator simpleCalculatorValidator) {
        this.simpleCalculatorValidator = simpleCalculatorValidator;
    }

    @Override
    public double performOperation(final SimpleCalculatorDTO simpleCalculatorDTO) {
        double result = 0;
        final String operator = simpleCalculatorDTO.getOperator();
        final Double firstValue = simpleCalculatorDTO.getFirstValue();
        final Double secondValue = simpleCalculatorDTO.getSecondValue();

        switch (operator) {
            case "add":
                result = this.add(firstValue, secondValue);
                break;
            case "subtract":
                result = this.subtract(firstValue, secondValue);
                break;
            case "multiply":
                result = this.multiply(firstValue, secondValue);
                break;
            case "divide":
                result = this.divide(firstValue, secondValue);
                break;
            default:
                throw new SimpleCalculatorException("Incorrect operator selected");
        }
        return result;
    }

    private double add(final Double firstValue, final Double secondValue) {
        final double result = firstValue + secondValue;
        return result;
    }

    private double subtract(final Double firstValue, final Double secondValue) {
        final double result = firstValue - secondValue;
        return result;
    }

    private double multiply(final Double firstValue, final Double secondValue) {
            final double result = firstValue * secondValue;
            return result;

    }

    private double divide(final Double firstValue, final Double secondValue) {
        if(!simpleCalculatorValidator.isZero(secondValue)) {
        final double result = firstValue / secondValue;
        return result;
        }else
        {
            throw new SimpleCalculatorException("second value can not be zero for divide operation");
        }

    }
}

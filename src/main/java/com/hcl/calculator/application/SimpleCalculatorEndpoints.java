package com.hcl.calculator.application;

import com.hcl.calculator.exception.SimpleCalculatorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/hcl/v1")
public class SimpleCalculatorEndpoints {
    private final SimpleCalculatorService simpleCalculatorService;

    SimpleCalculatorEndpoints(final SimpleCalculatorService simpleCalculatorService) {
        this.simpleCalculatorService = simpleCalculatorService;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping(value = "/calculate",consumes={"application/json"})
    public double calculateValue(@RequestBody SimpleCalculatorDTO simpleCalculatorDTO) {
        final double result;
        try {
            result = this.simpleCalculatorService.performOperation(simpleCalculatorDTO);
        } catch (final SimpleCalculatorException exc) {
            exc.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Incorrect Value, Please check your provided values", exc);
        }
        return result;
    }
}


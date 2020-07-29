package com.hcl.calculator.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SimpleCalculatorValidatorTest {

    @InjectMocks
    SimpleCalculatorValidator simpleCalculatorValidator;

    @Test
    public void testIsZero()
    {
        assertFalse(simpleCalculatorValidator.isZero(5d));
        assertTrue(simpleCalculatorValidator.isZero(0d));
    }
}

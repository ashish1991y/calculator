package com.hcl.calculator.application;

import com.hcl.calculator.exception.SimpleCalculatorException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SimpleCalculatorEndpointsTest {

    @Mock
    SimpleCalculatorDTO simpleCalculatorDTO;
    @Mock
    SimpleCalculatorService simpleCalculatorService;

    @Before
    public void setup() {
        when(simpleCalculatorService.performOperation(simpleCalculatorDTO)).thenReturn(5d);
    }

    @InjectMocks
    private SimpleCalculatorEndpoints simpleCalculatorEndpoints;

    @Test
    public void testCalculateValue_success() {
        assertEquals(5d, simpleCalculatorEndpoints.calculateValue(simpleCalculatorDTO), 0);
    }

    @Test(expected = ResponseStatusException.class)
    public void testCalculateValue_error() {
        when(simpleCalculatorService.performOperation(simpleCalculatorDTO)).thenThrow(SimpleCalculatorException.class);
        simpleCalculatorEndpoints.calculateValue(simpleCalculatorDTO);
    }
}

package com.hcl.calculator.application;

import com.hcl.calculator.exception.SimpleCalculatorException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SimpleCalculatorServiceImplTest {

    @Mock
    private SimpleCalculatorDTO simpleCalculatorDTO;
    @Mock
    private SimpleCalculatorValidator simpleCalculatorValidator;
    @Before
    public void setup()
    {

        when(simpleCalculatorDTO.getFirstValue()).thenReturn(4d);
        when(simpleCalculatorDTO.getSecondValue()).thenReturn(2d);
        when(simpleCalculatorValidator.isZero(anyDouble())).thenReturn(false);
    }

    @InjectMocks
    SimpleCalculatorServiceImpl simpleCalculatorServiceImpl;

    @Test
   public void testPerformOperation_add()
    {
        when(simpleCalculatorDTO.getOperator()).thenReturn("add");
        assertTrue(6d == simpleCalculatorServiceImpl.performOperation(simpleCalculatorDTO));
    }
    @Test
    public void testPerformOperation_subtract()
    {
        when(simpleCalculatorDTO.getOperator()).thenReturn("subtract");
        assertTrue(2d == simpleCalculatorServiceImpl.performOperation(simpleCalculatorDTO));
    }
    @Test
    public void testPerformOperation_multiply()
    {
        when(simpleCalculatorDTO.getOperator()).thenReturn("multiply");
        assertTrue(8d == simpleCalculatorServiceImpl.performOperation(simpleCalculatorDTO));
    }
    @Test
    public void testPerformOperation_divide()
    {
        when(simpleCalculatorDTO.getOperator()).thenReturn("divide");
        assertTrue(2d == simpleCalculatorServiceImpl.performOperation(simpleCalculatorDTO));
    }

    @Test(expected = SimpleCalculatorException.class)
    public void testPerformOperation_divide_zero()
    {
        when(simpleCalculatorValidator.isZero(anyDouble())).thenReturn(true);
        when(simpleCalculatorDTO.getOperator()).thenReturn("divide");
        simpleCalculatorServiceImpl.performOperation(simpleCalculatorDTO);
    }

    @Test(expected = SimpleCalculatorException.class)
    public void testPerformOperation_incorrect()
    {
        when(simpleCalculatorDTO.getOperator()).thenReturn("test");
        simpleCalculatorServiceImpl.performOperation(simpleCalculatorDTO);
    }
}

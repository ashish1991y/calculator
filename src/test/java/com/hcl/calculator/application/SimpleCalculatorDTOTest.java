package com.hcl.calculator.application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@SpringBootTest
@RunWith(SpringRunner.class)
public class SimpleCalculatorDTOTest {
    private static final Double FIRST_VALUE = 4d;
    private static final Double SECOND_VALUE = 6d;
    private static final String OPERATOR = "plus";
    private SimpleCalculatorDTO simpleCalculatorDTO;

    @Before
    public void setUp() throws Exception {
        this.simpleCalculatorDTO = new SimpleCalculatorDTO();
        this.simpleCalculatorDTO.setFirstValue(FIRST_VALUE);
        this.simpleCalculatorDTO.setSecondValue(SECOND_VALUE);
        this.simpleCalculatorDTO.setOperator(OPERATOR);
    }

    @Test
    public void testSimpleCalculatorDTO() throws Exception {
        assertNotNull(new SimpleCalculatorDTO());
        assertEquals(4d, this.simpleCalculatorDTO.getFirstValue(), 0);
        assertEquals(6d, this.simpleCalculatorDTO.getSecondValue(), 0);
        assertEquals("plus", this.simpleCalculatorDTO.getOperator());
    }
}



	package calculator;

	import org.junit.jupiter.api.Test;

	import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

	class StringCalculatorShould {

		private StringCalculator stringCalculator;
		
		@BeforeEach
	    public void init()
		{
			stringCalculator = new StringCalculator();
		}
		
		@Test
	    public void empty_string_should_return_0() 
		{
	        assertEquals(0, stringCalculator.add(""));
	    }
	    

	    @Test
	    public void string_with_single_number_should_return_number_as_int() 
	    {
	        assertEquals(1, stringCalculator.add("1"));
	    }
	    
	    
	    @Test
	    public void stringHavingTwoNumbers()
	    {
	        assertEquals(stringCalculator.add("20,40"),20+40);
	    }
	    
	    @Test
	    public void StringUnknownNumbers()
	    {
	    	assertEquals(10+20+30+60+50, stringCalculator.add("10,20,30,60,50"));
	    }
	    
	    @Test
	    public void stringWithTwoLinesBetNumbers()
	    {
	        assertEquals(9, stringCalculator.add("4\n5"));
	    }
	    
	    @Test
	    public void stringWithDifferentDelimeter()
	    {
	    	assertEquals(3+6+15, stringCalculator.add("//;\n3;6;15") );
	    }
	    
	    @Test
	    public void stringWithSingleNegativeNoThrowsException()
	    {
	    	assertThrows(RuntimeException.class, ()->
	    		
	    		stringCalculator.add("7,-6,5")
	    	);
	    }
	    
	    @Test
	    public void stringWithMultipleNegativeNoThrowsException()
	    {
	    		RuntimeException rex= null;
	    		try{
	    			stringCalculator.add("4,7,-8,11,15,-4");
	    		}catch(RuntimeException e)
	    		{
	    			rex=e;
	    		}
	    	
	    	assertNotNull(rex);
	    	assertEquals("negatives not allowed: [-8, -4]", rex.getMessage());
	    	
	    }
	}

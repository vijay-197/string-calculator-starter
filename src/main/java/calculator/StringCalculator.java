package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	

	  
	    	
	        private String delimiter = ",|\n";
	        
	        
	        public int add(String input)
	        {
	        	String[] nums = input.split(delimiter);
	        	String inputWithoutDelimiter = input;
	        	
	            if(isEmpty(input))
	            {
	            	return 0;
	            }
	            
	            if(input.startsWith("//"))
	        	{
	        		int delimiterIndex= input.indexOf("//")+2;
	        		delimiter = input.substring(delimiterIndex, delimiterIndex+1);
	        		inputWithoutDelimiter=input.substring(input.indexOf("\n"));
	        		return differentDelimiter(inputWithoutDelimiter, delimiter);
	        	}   
	            
	           negativeNumbers(nums);
	            
	            if(input.length() ==1)
	            {
	            	return stringtoint(input);
	            }
	            
	            if(input.length() >2)
	            {
	            	return sumOfMultipleNumbers(input,nums);
	            }
	        	else
	            {
	        		return sumOfTwoNumbers(nums[0], nums[1]);
	            }
	     
	        }
	        
	    	
	        private boolean isEmpty(String input)
	        {
	        	return input.isEmpty();
	        }
	        
	        private int stringtoint(String input)
	        {
	        	return Integer.parseInt(input);
	        }
	        
	      
	        private int sumOfTwoNumbers(String num1, String num2)
	        {
	        	return Integer.parseInt(num1) + Integer.parseInt(num2);
	        }
	        
	        
	        private int sumOfMultipleNumbers(String input, String[] nums) {
	        	int returnValue=0;
	        	
	        	for (String number : nums) {
	                if (!number.trim().isEmpty()) { 
	                    returnValue += Integer.parseInt(number);
	                }
	            }
	        	return returnValue;
	    	}
	        
	        
	        private int differentDelimiter(String input, String delimiter) 
	        {
	    		int returnVal=0;
	    		String[] numArray= input.split(delimiter);
	    		ArrayList negativeNums = new ArrayList();
	    		
	    		for (String number : numArray)
	    		{
	    			if(!number.trim().isEmpty())
	    			{
	    				returnVal += Integer.parseInt(number.trim());;
	    			}
	    		}

	    		return returnVal;
	    	}
	        
	       
	      	private void negativeNumbers(String[] nums) {
	      		
	      		List list = new ArrayList();
	              for(int i=0;i<nums.length;i++)
	              {
	              	if(Integer.parseInt(nums[i])<0)
	              	{
	              		list.add(nums[i]);
	              	}
	              }
	              if(list.size()>0)
	              {
	              	throw new RuntimeException("negatives not allowed: " + list.toString());
	              }
	      	}
	      	
	    }


/**
 * Author Ganesh Kumar Ramani.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;


class genRandomNumber
{

	int rLen;
	ArrayList<Integer> list;
	ArrayList<Integer> result;
	
	genRandomNumber(int numberOfDigit)
	{
		list = new ArrayList<Integer>();
		result = new ArrayList<Integer>();
		rLen = numberOfDigit + 1;
	}
	
	
	int getRandomNumber()
	{
		int i, j, num ;
		
		Random gen = new Random();
		i = 0;
	
		do	
		{
			num = gen.nextInt(rLen);
			
			if(!list.contains(num) && num > 0)
			{
				list.add(i, num);
				//System.out.println("List at "+ i + " : "+ num + " " + rLen);
				i++;
			}
			
		}while(i < rLen - 1);
		
		
		//Convert to Integer
		
		for(i = list.size() - 1, j = 0, num = 0; i >= 0; i --, j ++)
		
		   num += list.get(i) * Math.pow(10, j);
		
		//System.out.println (num);
		
		//result = (ArrayList<Integer>) list.subList(0, 3);
		
		for(i=0; i < 4; i ++)
		{
			j = list.get(i);
			result.add(i, j);
		}
		
		return num;
	}
}


class match extends genRandomNumber {
	
	int gValue;
	ArrayList <Integer> cList;
	String result;
	
	
	void clearClist()
	{
    	cList.add(0, 0);
    	cList.add(1, 0);
    	cList.add(2, 0);
    	cList.add(3, 0);
	}
	
	void setClist()
	{
    	cList.set(0, 0);
    	cList.set(1, 0);
    	cList.set(2, 0);
    	cList.set(3, 0);
	}
	
	
    match(int value)
    {
    	super(value);
    	
    	gValue = getRandomNumber();
    	
    	//Only 4 digits
    	
    	gValue /= 100;
    	
    	cList = new ArrayList<Integer>(4) ;
    	
    	result = new String("");
    	
    	clearClist();
    }
    
    String verify(int value)
    {
    	int reminder = 0;
    	int j = 3;
    	
    	if (value == gValue)
    		return "$$$$";

    	if (value > 9999 || value < 0)
    	{
			clearClist();
    		return "Invalid Number";
    	}
    	
    	result = "";
    	
    	while(value > 0)
    	{
    		reminder = value % 10;
    		
    		//Verify Index (j), val (reminder)
    		
    		//1. Add to Local List.
    		if(cList.contains(reminder))
    		{
    			setClist();
    			return "Repeat Integers";
    		}
    		
    		//Add into
    		cList.set(j, reminder);
    		
    		//Verify 
    		
    		if(super.result.get(j) == reminder)
    		{
    			//Placed  #TODO add $ at the beginning.
    			result = result.concat("$");
    		}
    		else if(super.result.contains(reminder))
    		{
    			//Misplaced
    			result = result.concat("%");
    		}
    		else
    		{
    			//Not Available
    			result = result.concat("O");
    		}
    		
    		value /= 10;
    		
    		j --;
    	}
    	
    	setClist();
    	
    	char[] array = result.toCharArray();
    	
    	Arrays.sort(array);
    	
    	return (new String(array));
    }
    
}


public class MyGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "";
		String output = "";
		int    Attampt = 0;
		
		match gMatch = new match(6);
		
		do
		{
		
			BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter 4 digit Number ");
			
			try
			{
				str = bs.readLine();
				
				if(str.length() != 4)
				{
					System.out.println("Invalid Input");
					continue;
				}
			}
			catch (Exception e)
			{
				System.out.println("Exception is :" + e.getMessage());
			}
						
			output = gMatch.verify(Integer.parseInt(str));
			if(!output.equals("Repeat Integers"))
			{
				System.out.println("( " + ++Attampt +" )" + output);
			}
			
			if(output.equals("$$$$"))
			{
				System.out.println("Congratulations.. You Done in " + Attampt + " Attampt");
				break;
			}
			
			if(Attampt == 10)
			{
				System.out.println("Attampts are Over !!! Number :: " + gMatch.gValue);
				break;
			}
			
		}while(true);
		
	}

}

package change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ChangeMakerImpl_Maharaj implements ChangeMaker
{	
	private Set<Integer> denominations;


	//part of pre: i <= 0 ==> !denominations.contains(i)
	//pre: must not contain any negatives or null
	public ChangeMakerImpl_Maharaj(Set<Integer> denominations)
	{
		assert denominations != null : "Denominations cannot be null.";

        this.denominations = denominations;

	}
	
	public List<Integer> getDenominations()
	{
		// Convert the Set to a List
        List<Integer> denominationSet = new ArrayList<>(denominations);
        Collections.sort(denominationSet);


        // Return the List
        return denominationSet;
		
		
	}
	//pre: value must be a positive integer
	public boolean canMakeExactChange(int valueInCents)
	{
		assert !(valueInCents < 0) : "value In cents should be a positive value.";

		//created an instance of a List and assigned it to the denomination in the getDenominations method
		List<Integer> denominations = getDenominations();
		//sort in descending order
		denominations.sort((preindex,postindex) -> Integer.compare(postindex,preindex));
		// Traditional for loop to iterate through each value of the denomination List
		for (int i = 0; i < denominations.size(); i++) {
	        int denomination = denominations.get(i);
	        //used a while loop to ensure that we are using the greedy method when subtracting the valueInCents from the denomination value
	        while (valueInCents>=denomination) {
				valueInCents -= denomination;
			}
	        //if valueinCents ==0 
			if (valueInCents==0) {
				return true;
			}
		
		}
		return false;
	}
	//pre: canMakeExactChange must be true
	//pre: chaneg lsit must not contain negatives or null
	public int calculateValueOfChangeList(List<Integer> changeList)
	{
		assert canMakeExactChange(0) != false :"Must be positive";
		assert changeList != null : "changeList can't be null";

		assert !denominations.isEmpty() && !changeList.isEmpty() : "Denominations and changeList should not be empty.";
		// Check if the list contains negative values
		
		// Check if canMakeExactChange is true
	    if (canMakeExactChange(0)) {
		//initialize an integer to 0
		int totalvalue =0;
		//call the getDenominations method
		List<Integer> denominations = getDenominations();
		//ran a for loop to go through the denominations and changelist lists
		for (int i = 0; i < denominations.size(); i++) {
	        int denomination = denominations.get(i);
			int changeListvalue = changeList.get(i);	
			assert !(changeList.contains(null) || changeListvalue < 0) : "List should not contain null or negatives.";
		        //add the changelistvalue to the denomination 
		        totalvalue += denomination * changeListvalue;
		        
	        }
		//return totalvalue
		return totalvalue;
		}
	    // Return -1 value when canMakeExactChange is false
	    return -1; 
	    
	}

	
	//pre: valueinCents must be a positive integer
	public List<Integer> getExactChange(int valueInCents)
	{
		assert !(valueInCents < 0) : "value In cents should be a positive value.";

		//initialzie an empty list 
		List<Integer> list=new ArrayList<Integer>();
		//call the denomination
		List<Integer> denominations = getDenominations();
		denominations.sort((preindex,postindex) -> Integer.compare(postindex,preindex));

		//initialize a value to the value of the cents
		int value = valueInCents;
		//loop through each value of the denomination
		for (int i = 0; i < denominations.size(); i++) {
			//get the vaue at the certain index i
	        int denomination = denominations.get(i);
	        //divide the value by the denomination value and add that value to the empty list
	        //adds 0 if the value is less than denomination 
	        if (value < denomination) {
	            list.add(0);
	        }
	        while (value >= denomination) {
	                int numberofCoinChange = value / denomination;
	                list.add(numberofCoinChange);
	          //update the value of value
	                value -= numberofCoinChange * denomination;
	            }
	       
		}
	        
	        //return the list
	        return list;
	    }
		
	public String toString()
	{
		//call getDenominations method
		List<Integer> denominations = getDenominations();
		//creates String Builder
		StringBuilder stringvalue = new StringBuilder("The denomination list is: ");
		//append the initalized value to the denominations list
		stringvalue.append(denominations);
		//converts StringBuilder to String
		return stringvalue.toString();

		}
		
}

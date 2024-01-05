package change;

import java.util.List;

public interface ChangeMaker {
	//Student: figure out my preconditions and postconditions
	//part of post: for i in [0, rv.size() - 1): rv.get(i) > rv.get(i + 1)
	public List<Integer> getDenominations();

	//pre: cannot be negative
	//cannot be null
	
	public boolean canMakeExactChange(int valueInCents);

	//Student: figure out my preconditions and postconditions
	//part of pre: canMakeExactChange(valueInCents)
	//part of post: calculateValueOfChangeList(rv) == valueInCents
	public List<Integer> getExactChange(int valueInCents);

	//Student: figure out my preconditions and postconditions
	//part of pre: changeList.size() == getDenominations().size()
	//part of post: rv == (
	//	getDenominations().get(0)*changeList.get(0) + 
	//	getDenominations().get(1)*changeList.get(1) +
	//	getDenominations().get(2)*changeList.get(2) +
	//					   ...
	//	getDenominations().get(getDenominations().size()-1)*changeList.get(changeList.size()-1)
	//					  )
	public int calculateValueOfChangeList(List<Integer> changeList);
}

package application;

import java.util.Comparator;

public class SortbyDate implements Comparator<Task>{

	// uses Task's date member to sort   
	@Override
	public int compare(Task t1, Task t2) {
		return t1.getDate().compareTo(t2.getDate());
	}

}

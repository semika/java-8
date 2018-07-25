package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("C","A", "B", "D"); 
		
		//sort using Lambda expresion.
		
		//strList.sort((s1, s2) -> s1.compareToIgnoreCase(s2)); 
		
		//sort using method referencs
		
		strList.sort(String::compareToIgnoreCase);
		
		System.out.println(strList); 
	}

}

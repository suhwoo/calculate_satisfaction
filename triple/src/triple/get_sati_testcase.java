package triple;

import java.util.*;

import triple.calcul_sati;

public class get_sati_testcase {
	public static void main(String[] args) {
		ArrayList<String> travelingPlace = new ArrayList<String>();
		int maxi=0;
		//testcase1
		travelingPlace.add("oh,2,5");
		travelingPlace.add("you,5,20");
		travelingPlace.add("do,1,10");
		travelingPlace.add("gi,3,30");
		maxi=calcul_sati.printSati(4, 5, travelingPlace);
		System.out.println(maxi);
		
		travelingPlace.clear();
		//testcase2
		travelingPlace.add("oh,2,5");
		travelingPlace.add("you,5,20");
		travelingPlace.add("do,1,10");
		travelingPlace.add("gi,3,30");
		maxi=calcul_sati.printSati(4, 3, travelingPlace);
		System.out.println(maxi);
	} 
}

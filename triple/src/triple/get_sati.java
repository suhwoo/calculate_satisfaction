package triple;
import java.util.ArrayList;
import java.util.Scanner;

import triple.calcul_sati;

public class get_sati {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ArrayList<String> travelingPlace = new ArrayList<String>();
		
		int placeNum=in.nextInt();
		int travelTime=in.nextInt();
		String tempString=in.nextLine();
		
		for(int num=0;num<placeNum;num++) {
			tempString=in.nextLine();
			travelingPlace.add(tempString);
		}
		int maxi=calcul_sati.printSati(placeNum, travelTime, travelingPlace);
		System.out.println(maxi);
	} 
}

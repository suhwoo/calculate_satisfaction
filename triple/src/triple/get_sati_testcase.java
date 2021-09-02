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
		travelingPlace.clear();
		
		//testcase3 소요시간이 같은 장소가 있는경우.
		//이 경우 2+2+1 인 경우 65로 가장 크게 나온다.
		travelingPlace.add("oh,2,30");
		travelingPlace.add("you,5,20");
		travelingPlace.add("do,2,30");
		travelingPlace.add("gi,1,5");
		maxi=calcul_sati.printSati(4, 5, travelingPlace);
		System.out.println(maxi);
		travelingPlace.clear();
		
		//testcase4 만족도가 모두 같을 경우.
		//경로를 구하는게 아니라 최대 만족도를 구하는 것이므로 경로가 여러개 나오는건 상관없음.
		//결과는 10이 나온다.
		travelingPlace.add("oh,1,5");
		travelingPlace.add("you,1,5");
		travelingPlace.add("do,1,5");
		travelingPlace.add("gi,1,5");
		maxi=calcul_sati.printSati(4, 2, travelingPlace);
		System.out.println(maxi);
		travelingPlace.clear();
		
		//testcase5 한 여행지의 소요시간이 여행시간을 넘기는 경우, 예외처리 잘 됐는지 체크
		//소요시간이 7인 oh는 제외처리되야한다. 10이 나온다.
		travelingPlace.add("oh,7,100");
		travelingPlace.add("you,1,5");
		travelingPlace.add("do,1,5");
		travelingPlace.add("gi,1,5");
		maxi=calcul_sati.printSati(4, 2, travelingPlace);
		System.out.println(maxi);
		travelingPlace.clear();
	} 
}

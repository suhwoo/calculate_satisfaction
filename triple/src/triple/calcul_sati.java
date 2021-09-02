package triple;
import java.util.*;

public class calcul_sati {
	static int max_sati=-1;
	
	class Node{
		public String name;
		public int spendTime;
		public int satisfaction;
		public Node(String name,int spendTime,int satisfaction) {
			this.name=name;
			this.spendTime=spendTime;
			this.satisfaction=satisfaction;
		}
		public String getName() {
			return name;
		}
		public int getSpendTime() {
			return spendTime;
		}
		public int getSatisfaction() {
			return satisfaction;
		}
	}
	public static void findRoute(ArrayList<Node> travelList,int totalTime,int nowIndex,int nowTime,int nowSati) {
		//매개변수:저장된 여행지목록,정해진 시간, 현재 여행지, 지금까지 경로의 총 소요시간, 지금까지 경로의 총 만족도
		if(nowTime > totalTime)return;
		if(nowIndex==travelList.size() && nowTime <= totalTime) {
			if(nowSati > max_sati) {
				max_sati=nowSati;
			}
			return;
		}
		
		//경로에 포함되었을 경우
		findRoute(travelList,totalTime,nowIndex+1,nowTime+travelList.get(nowIndex).getSpendTime(),nowSati+travelList.get(nowIndex).getSatisfaction());
		//경로에 포함되지않았을 경우
		findRoute(travelList,totalTime,nowIndex+1,nowTime,nowSati);
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//input 저장
		int placeNum= in.nextInt();
		int travelTime = in.nextInt();
		String tempString=in.nextLine();
		
		String name=null;
		int time=0;
		int sati=0;
		ArrayList<Node> travelList=new ArrayList<Node>();
		
		//1.주어진 여행시간 n보다 오래걸리는 경로를 제외
		for(int num=0;num<placeNum;num++) {
			tempString=in.nextLine();
			//콤마로 구분해서 input 받기
			String[] words = tempString.split(",");
			name=words[0];
			time=Integer.parseInt(words[1]);
			sati=Integer.parseInt(words[2]);
			words=null;
			Node place=new calcul_sati().new Node(name,time,sati);
			travelList.add(place);
		}
		//2.dfs이용해서 경로를 정한다. 경로로 채택되거나 혹은 채택되지 않거나
		findRoute(travelList,travelTime,0,0,0);
		//3.구해진 경우의 수 중에 가장 만족도 총합이 높은 경로 출력하기
		System.out.println(max_sati);
		
		
	}
}

#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
using namespace std;
struct Node {
	string placeName = "";
	int spendTime = 0;
	int satisfaction = 0;
};
vector<Node> travelList;
int maxSati = -1;//가장 큰 만족도가 저장되는 변수

void findRoute(int totalTime,int nowIndex,int nowTime,int nowSati) {//매개변수:정해진 시간, 현재 여행지, 지금까지 경로의 총 소요시간, 지금까지 경로의 총 만족도
	if (nowTime > totalTime) {//현재 계산된 소요시간이 정해진 시간보다 클경우 return
		return;
	}
	if (nowIndex==travelList.size() && nowTime <= totalTime) {//경로가 정해지고 소요시간이 총시간보다 작을 경우
		if (nowSati > maxSati) {
			maxSati = nowSati;
		}
		return;
	}

	//경로에 포함되었을 경우
	findRoute(totalTime, nowIndex + 1, nowTime + travelList[nowIndex].spendTime, nowSati+travelList[nowIndex].satisfaction);
	//경로에 포함되지않았을 경우
	findRoute(totalTime, nowIndex + 1, nowTime, nowSati);

}

int main() {
	//input 저장
	int placeNum;
	int travelTime;

	string temp = "";
	string delimiter = ",";
	

	string name = "";
	int time;
	int sati;

	cin >> placeNum >> travelTime;
	//1.주어진 여행시간 n보다 오래걸리는 경로를 제외
	for (int num = 0; num < placeNum; num++) {
		//콤마로 구분해서 input 받기
		cin >> temp;
		
		//예외처리. 여행시간보다 장소를 가는 시간이 더 길 경우, 애초에 여행경로에 넣지않는다.
		if (time > travelTime)continue;
		//아닐 경우, 경로로 채택될 수 있으므로 vector에 넣는다.
		Node temp = { name,time,sati };
		travelList.push_back(temp);
	}
	//2.dfs이용해서 경로를 정한다. 경로로 채택되거나 혹은 채택되지 않거나
	findRoute(travelTime,0,0,0);
	//3.구해진 경우의 수 중에 가장 만족도 총합이 높은 경로 출력하기
	cout << maxSati;
	return 0;
}

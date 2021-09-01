#include <iostream>
#include <string>
#include <vector>
using namespace std;
struct Node {
	string placeName = "";
	int spendTime = 0;
	int satisfaction = 0;
};
vector<Node> travelList;
//장소개수가 20개니까 priority queue쓰지말고 매번 탐색해도 시간 얼마 안걸릴듯..? 시간 걸리면 시간 순으로 나열하는 거 고려해보기.(이때는 string 안써도 될듯. 경로를 구하는게 아니니까)

int main() {
	//일단 input 저장하자
	int placeNum;
	int travelTime;
	string name = "";
	int time;
	int sati;
	cin >> placeNum >> travelTime;
	for (int num = 0; num < placeNum; num++) {
		cin >> name >> time >> sati;
		Node temp = { name,time,sati };
		travelList.push_back(temp);
	}
	//0.dp쓰면 안됌->여행지를 한번씩밖에 못 쓰니까.
	//1.일단 주어진 여행시간 n보다 오래걸리는 경로를 제외하고
	//2.dfs이용해서 총 더했을때 n이 나오는 경우의 수를 구한다.
	//3.만약 가는데 걸리는 시간이 같으면 -> 만족도가 더 높은 곳으로 덮어쓰기 ->생각해보니 그러면 안됌->2시간+2시간+1시간이면 둘다 써야함
	//4.구해진 경우의 수 중에 가장 만족도 총합이 높은 경로 출력하기->이거만 하면 될듯. 어차피 만족도로 계산하면 되니까
	return 0;
}
/*

숫자뽑는것까지 함
이제 Check 하는거 해야댐

*/
#include<iostream>
#include<vector>
#include<string>
#include<time.h>
#include<fstream>
#include<sstream>

//Second Check의 중복 개수 설정
#define DuplicateCnt 4

using namespace std;

vector<int> JackPot();
int FirstCheck();
int SecondCheck();
vector<string> split(string, char);
vector<vector<int>> Origin;
vector<vector<int>> Choice;
int temp[6] = { 0, };
int main() {
	//파일읽기
	string filePath = "data.txt";
	ifstream openFile(filePath.data());
	if (openFile.is_open()) {
		string line;
		while (getline(openFile, line)) {
			vector<string> line_vector = split(line, '\t');
			vector<int> temp;
			for (int i = 0; i < line_vector.size(); i++) {
				temp.push_back(atoi(line_vector[i].c_str()));
			}
			Origin.push_back(temp);
		}
	}
	for (int i = 0; i < Origin.size(); i++) {
		for (int ii = 0; ii < Origin[i].size(); ii++) {
			cout << Origin[i][ii] << " ";
		}
		cout << endl;
	}

	int num;

	cout << "Please Type How Many Choice" << endl;
	cin >> num;
	int cnt = 0;
	//Start
	while (1) {
		int check1 = 0;
		int check2 = 0;
		vector<int> Select;
		//Choice에 아무것도 없을때
		if (Choice.size() == 0) {
			
			Select = JackPot();
			//Check
			check1 = FirstCheck();
			//데이터가 괜찮다면 Push
			if (check1 == 1) {
				Choice.push_back(Select);
				cnt++;
			}
		}
		else {
			Select = JackPot();
			//Check
			check1 = FirstCheck();
			check2 = SecondCheck();
			if (check1 == 1 && check2 == 1) {
				Choice.push_back(Select);
				cnt++;
			}
			cnt++;
		}
		//데이터를 어느정도 집어넣었을 때
		if (num <= cnt)
			break;
	}

	return 0;
}
//수를 뽑는다
vector<int> JackPot() {
	vector<int> temp;
	srand(time(NULL));
	//1~20
	int first = rand() % 20 + 1;
	temp.push_back(first);

	//3~30
	vector<int> ::iterator iter;
	while (true) {
		int second = rand() % 28 + 3;
		iter = find(temp.begin(), temp.end(), second);
		//중복되지 않는다면
		if (iter == temp.end()){
			temp.push_back(second);
			break;
		}
	}
	//6~38
	while (true) {
		int third = rand() % 33 + 6;
		iter = find(temp.begin(), temp.end(), third);
		//중복되지 않는다면
		if (iter == temp.end()) {
			temp.push_back(third);
			break;
		}
	}
	//11~40
	while (true) {
		int fourth = rand() % 30 + 11;
		iter = find(temp.begin(), temp.end(), fourth);
		//중복되지 않는다면
		if (iter == temp.end()) {
			temp.push_back(fourth);
			break;
		}
	}
	//21~43
	while (true) {
		int fifth = rand() % 23 + 21;
		iter = find(temp.begin(), temp.end(), fifth);
		//중복되지 않는다면
		if (iter == temp.end()) {
			temp.push_back(fifth);
			break;
		}
	}
	//28~45
	while (true) {
		int sixth = rand() % 16 + 28;
		iter = find(temp.begin(), temp.end(), sixth);
		//중복되지 않는다면
		if (iter == temp.end()) {
			temp.push_back(sixth);
			break;
		}
	}

	return temp;
}
//기존에 나온값과 동일한 수는 제외
int FirstCheck() {

	return 0;
}
//뽑았던 수중 동일한 수의 개수만큼 제외
int SecondCheck() {
	return 0;
}

vector<string> split(string str, char delimiter) {
	vector<string> internal;
	stringstream ss(str);
	string temp;

	while (getline(ss, temp, delimiter)) {
		internal.push_back(temp);
	}

	return internal;
}
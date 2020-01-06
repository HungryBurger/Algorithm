#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>
#include <string>

using namespace std;

vector <string>solution(vector<string>);
int main(void) {
	vector<string> input = { "RECEIVE abc@naver.com", "RECEIVE awerwerbc@naver.com" ,"DELETE", "SAVE"};
	solution(input);

	return 0;
}
vector <string> solution(vector<string> record) {
	//영구
	vector<string>answer;
	//임시
	vector<string>temp;
	for (int i = 0; i < record.size(); i++) {
		if (record[i][0] == 'R') {
			temp.push_back(record[i].substr(8));
		}
		else if (record[i][0] == 'D') {
			temp.pop_back();
		}
		else if (record[i][0] == 'S') {
			for (int k = 0; k < temp.size(); k++) {
				answer.push_back(temp[k]);
			}
			temp.clear();
		}
	}
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i];
	}
	return answer;
}
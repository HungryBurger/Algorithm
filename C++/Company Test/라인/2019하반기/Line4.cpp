#include <iostream>
#include <vector>
#include <string.h>
#include <string>
#include <algorithm>
using namespace std;

int main(void) {

	vector<int> num;
	vector<char*> character;
	char* str_buff = new char[400001];
	string input;
	int size_value = 0;
	cin >> size_value;
	cin.ignore();
	getline(cin, input);

	strcpy(str_buff, input.c_str());

	char* tok2 = strtok(str_buff, " ");
	while (tok2 != NULL) {
		character.push_back(tok2);
		tok2 = strtok(NULL, " ");
	}

	for (int i = 0; i < size_value; i++) {
		int min_value = 0;
		int left_distance = 0;
		int right_distance = 0;
		if (strcmp(character[i], "0"))
		{
			//1일경우엔 앉을 수 없다.
			num.push_back(9999);
			continue;
		}
		for (int left = i; left > 0; left--) {
			if (strcmp(character[left], "0"))
			{
				left_distance = i - left;
				break;
			}
			if (left == 0) {
				left_distance = i;
			}
		}
		for (int right = i; right < character.size(); right++) {
			if (strcmp(character[right], "0")) {
				right_distance = right - i;
				break;
			}
			if (right == character.size() - 1) {
				right_distance = character.size() - i;
			}
		}
		num.push_back(left_distance + right_distance);
	}
	auto smallest = min_element(begin(num), end(num));
	int idx = distance(begin(num), smallest);
	cout << idx + 1;
	return 0;
}
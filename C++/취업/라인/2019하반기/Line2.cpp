#include <iostream>
#include <istream>
#include <algorithm>
#include <vector>
#include <string>
#include <cstring>
#include <stdlib.h>
using namespace std;

int main(void) {
	vector<string> num;
	vector<char*> character;
	char* str_buff = new char[22];
	string input;
	int rank;

	getline(cin, input);
	cin >> rank;
	strcpy(str_buff, input.c_str());

	char* tok2 = strtok(str_buff, " ");
	while (tok2 != NULL) {
		character.push_back(tok2);
		tok2 = strtok(NULL, " ");	
	}
	do {
		char* temp= new char[character.size()]();
		for (int i = 0; i < character.size(); i++) {
			strcat(temp,character[i]);
		}
		num.push_back(temp);
	} while (next_permutation(character.begin(), character.end()));
	sort(num.begin(), num.end());
	cout << num[rank-1];
	return 0;
}
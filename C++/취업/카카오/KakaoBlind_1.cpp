#include<cstdio>
#include<string>
#include<vector>
#include<iostream>
#include<algorithm>

using namespace std;

int solution(string);

int main() {
	string input = "abcabcabcabcabcabcabcgg";
	cout << solution(input);
}
int solution(string s) {
	int answer = s.length();
	if (answer == 1||answer==0) {
		return answer;
	}
	for (int i = 1; i <= s.length(); i++) {
		string replace="";
		int minLength = s.length();
		int start = 0;
		int count = 0;
		for (int a = 0; a < s.length(); a += i) {
			//만약 값을 넘게 찾는다면
			if (a > s.length() - i) {
				if (count == 1 || count == 0) {
					replace += s.substr(start);
				}
				else {
					replace += to_string(count) +s.substr(a-i);
				}
				break;
			}
			else if (a == s.length() - i) {
				if (s.substr(start, i).compare(s.substr(a, i)) == 0) {
					count++;
					replace += to_string(count) + s.substr(start, i);
				}
				else {
					if (count == 1 || count == 0) {
						replace += s.substr(start);
					}
					else {
						replace += to_string(count) + s.substr(a - i);
					}
				}
				break;
			}
			else
			{
				//검색열과 같다면
				if (s.substr(start, i).compare(s.substr(a, i)) == 0) {
					count++;
				}
				//검색열과 다르다면
				else {
					if (count == 1) {
						replace += s.substr(start, i);
					}
					else {
						replace += to_string(count) + s.substr(start, i);
					}
					start = a;
					count = 1;
				}
			}
		}
		minLength = replace.length();
		answer = min(answer, minLength);
	}
	return answer;
}
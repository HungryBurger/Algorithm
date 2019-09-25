
#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string);


int main() {
	string output;
	string input = "";
	output = solution(input);
	cout << output;
}
string solution(string p) {
	string answer = p;
	if (p.compare("")==0) {
		return answer;
	}
	int right = 0, left = 0, start = 0;
	for (int i = 0; i < p.length(); i++) {
		char temp;
		if (p[i]=='(') {
			left++;
		}
		else if (p[i] == ')') {
			right++;
		}
		//±ÕÇüÀâÈù ¹®ÀÚ¿­
		if (left == right) {
			int l_count = 0;
			int b = i;
			for (int a = start; a <= (i+start)/2; a++) {
				if (p[a] == '(') {
					l_count++;
				}
				else if (p[a] == ')') {
					l_count--;
					if (l_count <= 0) {
						temp = p[a];
						p[a] = p[b];
						p[b] = temp;
					}
				}
				b--;
			}
			start = i+1;
		}
	}
	answer = p;
	return answer;
}
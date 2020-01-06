#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>
#include <string>

using namespace std;

long long solution(int);
int main(void) {
	vector<int> input;
	int num;
	cin >> num;
	solution(num);
	return 0;
}
long long solution(int n) {
	long long answer = 0;
	vector<long long> num;
	long long result;
	for (long long p = 1; p < n; p++) {
		long long multi = 1;
		for (long long i = p; i <= n; i++) {
			multi *= i;
		}
		cout << multi;
		cout << endl;
	}

	/*
	for (int i = 2; i <= n + 1; i++) {
		do {
			int multi = 1;
			for (int p = 0; p < n + 1; p++) {
				for (int k = p; k < i; k++) {
					multi *= num[k];
				}
				result.push_back(multi);
			}
		} while (next_permutation(num.begin(), num.end()));
	}
	sort(num.begin(), num.end());
	cout << result[n];
	*/
	return answer;
}
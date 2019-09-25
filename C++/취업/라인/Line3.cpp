#include <iostream>
#include <vector>
#include <string.h>
#include <string>
#include <algorithm>
using namespace std;

int main(void) {
	vector<vector<int> > arr;

	int N;
	int result = 0;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int a, b;
		vector<int> element;
		cin >> a >> b;
		element.push_back(a);
		element.push_back(b);
		arr.push_back(element);
	}

	for (int i = 0; i < arr.size(); i++) {
		int count = 0;
		for (int k = 0; k < arr.size(); k++)
		{
			if (i == k) {
				continue;
			}
			if (arr[i][0] < arr[k][0] && arr[i][1] > arr[k][1] ||
				arr[i][0] > arr[k][0] && arr[i][1] < arr[k][1] ||
				arr[i][0] < arr[k][0] && arr[i][1] < arr[k][1] ||
				arr[i][0] > arr[k][0] && arr[i][1] > arr[k][1])
			{
				count++;
			}
		}
		result = max(result, count);
	}
	cout << result;
	return 0;
}
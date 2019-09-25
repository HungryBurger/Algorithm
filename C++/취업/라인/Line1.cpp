#include <iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(void) {
	int a;
	int b;
	vector<int> input;
	int sum = 0;

	cin >> a >> b;

	vector<int> consumer(b, 0);

	for (int i = 0; i < a; i++) {
		int temp;
		cin >> temp;
		input.push_back(temp);
	}
	for (int i = 0; i < input.size(); i++) {
		auto smallest = min_element(begin(consumer), end(consumer));
		int idx = distance(begin(consumer), smallest);
		consumer[idx] += input[i];
	}
	auto biggest = max_element(begin(consumer), end(consumer));
	cout << *biggest;

	return 0;
}
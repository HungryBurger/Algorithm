#include<iostream>
#include<algorithm>
#include<vector>
#include<ios>
using namespace std;

void DFS(int, int);

int max_ans = -1e10, min_ans = 1e10;
int N;

vector<int> val;
vector<int> oper(4, 0);
int main()
{
	int temp;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> temp;
		val.push_back(temp);
	}
	for (int i = 0; i < 4; i++) {
		cin >> oper[i];
	}

	DFS(1, val[0]);

	cout << max_ans << endl;
	cout << min_ans << endl;
	return 0;

}
void DFS(int count, int result) {
	if (count == N) {
		max_ans = max(max_ans, result);
		min_ans = min(min_ans, result);
	}
	else {
		for (int i = 0; i < 4; i++) {
			if (oper[i] == 0)
				continue;
			oper[i]--;
			if (i == 0) {
				DFS(count + 1, result + val[count]);
			}
			else if (i == 1) {
				DFS(count + 1, result - val[count]);
			}
			else if (i == 2) {
				DFS(count + 1, result * val[count]);
			}
			else if (i == 3) {
				DFS(count + 1, result / val[count]);
			}
			oper[i]++;
		}
	}
}

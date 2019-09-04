#include<iostream>
#include<algorithm>
using namespace std;

int N, T[16], P[16];
int result = 0;

int dfs(int,int);
int main()
{
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> T[i];
		cin >> P[i];
	}
	cout << dfs(1,0) << endl;
}
int dfs(int go,int sum) {
	if (go == N+1) {
		result = max(result, sum);
		return result;
	}
	if (go + T[go] <= N + 1) {
		dfs(go + T[go], sum + P[go]);
	}
	if (go + 1 <= N + 1) {
		dfs(go + 1, sum);
	}
}
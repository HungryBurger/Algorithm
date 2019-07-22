#include<queue>
#include<cstdio>
#include<cstring>
using namespace std;
int adj[1001][1001] = { 0, };
int visit[1001]= { 0, };
int N, M, start;
void DFS(int);
void BFS(int);
int main()
{
	int a, b;
	scanf("%d %d %d", &N, &M, &start);
	for (int i = 0; i < M; i++)
	{
		scanf("%d %d", &a, &b);
		adj[a][b] = 1;
		adj[b][a] = 1;
	}

	DFS(start);
	//방문 초기화
	memset(visit, 0, sizeof(visit));
	printf("\n");
	BFS(start);
	return 0;
}
void DFS(int go) {
	visit[go] = 1;
	printf("%d ", go);
	for (int i = 1; i <= N; i++) {
		if (adj[go][i] == 1 && visit[i] == 0){
			DFS(i);
		}
	}
}

void BFS(int go)
{
	queue<int> Q;
	Q.push(go);
	visit[go] = 1;
	while (!Q.empty()) {
		int a = Q.front();
		printf("%d ", a);
		Q.pop();
		for (int i = 1; i <=N; ++i) {
			if (adj[a][i] == 1 && visit[i] == 0) {
				visit[i] = 1;
				Q.push(i);
			}
		}
	}
}
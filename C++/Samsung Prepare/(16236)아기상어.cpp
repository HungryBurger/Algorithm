
/*
���� �Ʊ���

�ڱⰡ ���� �� �ִ� �������� Ž���ϰ� �ű⼭ ���� ����� ģ���� �ȳ��Ѵ�.
�� �԰� �Դٰ� �ڱ� �� ��ŭ ������ �ڱ� ���� ũ�⸦ ������Ų��.
�� �԰� ������ ������ Ž���� �����Ѵ�.

*/

#include<iostream>
#include<algorithm>
#include<string>
#include<queue>

using namespace std;

int map[21][21] = { 0, };

struct shark {
	int x;
	int y;
	int distance;
};
int N;
int dx[4] = { 1,-1,0, 0 };
int dy[4] = { 0,0,1,-1 };
int shark_size = 2;
int answer = 0;
int eat_cnt = 0;
struct shark shark_pos;
void Solution();

bool operator<(shark a, shark b) {
	if (a.distance > b.distance)
		return true;
	else if (a.distance == b.distance) {
		if (a.y > b.y)
			return true;
		else if (a.y == b.y) {
			if (a.x > b.x)
				return true;
		}
	}
	return false;
}
int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int k = 0; k < N; k++) {
			cin >> map[i][k];
			if (map[i][k] == 9) {
				shark_pos.x = k;
				shark_pos.y = i;
				map[shark_pos.y][shark_pos.x] = 0;
			}

		}
	}
	Solution();
	
	return 0;
}
void Solution()
{
	while (1) {
		int visit[21][21] = { 0, };
		priority_queue<shark> pq;
		queue<shark> q;
		shark_pos.distance = 0;
		visit[shark_pos.y][shark_pos.x] = 1;
		q.push(shark_pos);

		while (!q.empty()) {
			shark cur = q.front();
			q.pop();

			if (map[cur.y][cur.x] != 0 && map[cur.y][cur.x] < shark_size) {
				pq.push(cur);
			}
			for (int i = 0; i < 4; i++)
			{
				shark next;
				next.x = cur.x + dx[i];
				next.y = cur.y + dy[i];
				next.distance = cur.distance + 1;

				if (next.y < 0 || next.x < 0 || next.y >= N || next.x >= N || visit[next.y][next.x] == 1 || map[next.y][next.x] > shark_size)
					continue;
				visit[next.y][next.x] = 1;
				q.push(next);
			}
		}

		if (pq.size() == 0)
			break;
		shark_pos = pq.top();
		map[shark_pos.y][shark_pos.x] = 0;
		answer += shark_pos.distance;

		eat_cnt++;
		if (eat_cnt == shark_size) {
			shark_size++;
			eat_cnt = 0;
		}
	}
	cout << answer;
}
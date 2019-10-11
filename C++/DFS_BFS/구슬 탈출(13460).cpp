#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct data {
	int rx, ry, bx, by, d;
};
void BFS();

char map[10][10] = { '\0' };
bool check[10][10][10][10];
queue<struct data> q;

const int dir_x[] = { -1, 0, 1, 0 }, dir_y[] = { 0, 1, 0, -1 };

int main()
{
	int N, M;
	int Rx = 0, Ry = 0;
	int Bx = 0, By = 0;

	cin >> N >> M;
	for (int a = 0; a < N; a++) {
		for (int b = 0; b < M; b++) {
			char temp;
			cin >> temp;
			map[a][b] = temp;

			if (temp == 'R') {
				Rx = a;
				Ry = b;
			}
			else if (temp == 'B') {
				Bx = a;
				By = b;
			}
		}
	}
	q.push({ Rx, Ry, Bx, By, 0 });
	check[Rx][Ry][Bx][By] = true;
	BFS();

	return 0;
}
//움직였을때 사용하는 사용하는 함수
void move(int& x, int& y, int& c, int dx, int dy) {
	while (map[x + dx][y + dy] != '#' && map[x][y] != 'O') {
		x += dx;
		y += dy;
		c += 1;
	}
}

void BFS()
{
	while (!q.empty()) {
		int R_x = q.front().rx;
		int R_y = q.front().ry;
		int B_x = q.front().bx;
		int B_y = q.front().by;
		int d = q.front().d;
		q.pop();

		if (d >= 10) {
			break;
		}
		for (int i = 0; i < 4; i++) {
			int nrx = R_x; int nry = R_y;
			int nbx = B_x; int nby = B_y;
			//빨간공과 파란공의 간 거리
			int rc = 0; int bc = 0;
			int nd = d + 1;
			//파란공과 빨간공을 움직이기
			move(nrx, nry, rc, dir_x[i], dir_y[i]);
			move(nbx, nby, bc, dir_x[i], dir_y[i]);

			//파란색 공이 도착 지점이라면
			if (map[nbx][nby] == 'O')
				continue;
			//빨간색 공이 도착 지점이라면
			if (map[nrx][nry] == 'O') {
				cout << nd;
				return;
			}
			//빨간색 공이랑 파란색 공이 같은 위치라면
			if (nrx == nbx && nry == nby) {

				if (rc > bc) {
					nrx -= dir_x[i];
					nry -= dir_y[i];
				}
				else {
					nbx -= dir_x[i];
					nby -= dir_y[i];
				}
			}
			if (check[nrx][nry][nbx][nby])
				continue;
			check[nrx][nry][nbx][nby] = true;
			q.push({ nrx,nry,nbx,nby,nd });
		}
	}
	cout << "-1" << endl;
}
/*
#include <cstdio>
#include <queue>
using namespace std;

struct bead {
	int rx, ry, bx, by, d;
};

int n, m;
char a[10][10];
bool check[10][10][10][10];
queue<bead> q;
const int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, 1, 0, -1 };

void move(int& x, int& y, int& c, int dx, int dy) {
	while (a[x + dx][y + dy] != '#' && a[x][y] != 'O') {
		x += dx;
		y += dy;
		c += 1;
	}
}

void bfs() {
	while (!q.empty()) {
		int rx = q.front().rx, ry = q.front().ry;
		int bx = q.front().bx, by = q.front().by;
		int d = q.front().d; q.pop();
		if (d >= 10) break;
		for (int i = 0; i < 4; i++) {
			int nrx = rx, nry = ry, nbx = bx, nby = by;
			int rc = 0, bc = 0, nd = d + 1;
			move(nrx, nry, rc, dx[i], dy[i]);
			move(nbx, nby, bc, dx[i], dy[i]);
			if (a[nbx][nby] == 'O') continue;
			if (a[nrx][nry] == 'O') {
				printf("%d\n", nd);
				return;
			}
			if (nrx == nbx && nry == nby) {
				if (rc > bc) nrx -= dx[i], nry -= dy[i];
				else nbx -= dx[i], nby -= dy[i];
			}
			if (check[nrx][nry][nbx][nby]) continue;
			check[nrx][nry][nbx][nby] = true;
			q.push({ nrx, nry, nbx, nby, nd });
		}
	}
	printf("-1\n");
}

int main() {
	scanf("%d %d", &n, &m);
	int rx = 0, ry = 0, bx = 0, by = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1s", &a[i][j]);
			if (a[i][j] == 'R') rx = i, ry = j;
			else if (a[i][j] == 'B') bx = i, by = j;
		}
	}
	q.push({ rx, ry, bx, by, 0 });
	check[rx][ry][bx][by] = true;
	bfs();
	return 0;
}

*/
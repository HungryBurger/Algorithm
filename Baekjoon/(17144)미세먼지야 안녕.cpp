#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int C, R, T;
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };
int ccw[4] = { 0,3,1,2 };
int cw[4] = { 0,2,1,3 };


struct cleaner {
	int first[2] = { -1,-1 };
	int second[2] = { -1,-1 };
};
struct cleaner CL;
int map[51][51] = { 0, };
int copy_map[51][51] = { 0, };
void calculate(int, int, int*);
void expand();
int main()
{
	cin >> C >> R >> T;

	for (int i = 0; i < C; i++) {
		for (int k = 0; k < R; k++) {
			cin >> map[i][k];
			if (map[i][k] == -1) {
				if (CL.first[0] == -1) {
					CL.first[1] = i;
					CL.first[0] = k;
				}
				else {
					CL.second[1] = i;
					CL.second[0] = k;
				}
			}
		}
	}
	for (int i = 0; i < T; i++) {
		copy(&map[0][0], &map[0][0] + 51 * 51, &copy_map[0][0]);
		expand();
		copy(&map[0][0], &map[0][0] + 51 * 51, &copy_map[0][0]);
		//아래쪽
		calculate(CL.first[0], CL.first[1], ccw);
		//윗쪽
		calculate(CL.second[0], CL.second[1], cw);
	}
	int sum = 0;
	for (int i = 0; i < C; i++) {
		for (int k = 0; k < R; k++) {
			if (map[i][k] != -1) {
				sum += map[i][k];
			}
		}
	}
	cout << sum << endl;
}
//확산시키기
void expand() {
	for (int i = 0; i < C; i++) {
		for (int k = 0; k < R; k++) {
			int expandCnt = 4;
			for (int p = 0; p < 4; p++) {
				if ((k + dx[p]) >= 0 && (k + dx[p]) < R && 
					(i + dy[p]) >= 0 && (i + dy[p]) < C && 
					map[i + dy[p]][k + dx[p]] != -1) {
					map[i + dy[p]][k + dx[p]] += copy_map[i][k] / 5;
				}
				else {
					expandCnt--;
				}
			}
			if (!(copy_map[i][k] == -1 || copy_map[i][k] == 0))
				map[i][k] = map[i][k] - (copy_map[i][k] / 5 * expandCnt);
		}
	}
}
//공기청정기
void calculate(int clX, int clY, int* direction) {
	int x = clX + 1;
	int y = clY;
	map[y][x] = 0;
	for (int i = 0; i < 4; i++) {
		while (true) {
			int nx = x + dx[direction[i]];
			int ny = y + dy[direction[i]];
			if (!(nx >= 0 && nx < R && ny >= 0 && ny < C)) {
				break;
			}
			if (clX == nx && clY == ny) {
				break;
			}
			map[ny][nx] = copy_map[y][x];
			y = ny;
			x = nx;
		}
	}
}
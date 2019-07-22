/*#include<stdio.h>
int chk[201][201][201];
int main()
{
	int q[3][802], ans[201], give[3];
	int max[3];
	int i, j;
	int temp;

	scanf("%d %d %d", &max[0], &max[1], &max[2]);
	//물통 초기값
	q[0][1] = 0;
	q[1][1] = 0;
	q[2][1] = max[2];
	
	chk[0][0][max[2]] = 1;
	ans[max[2]] = 1;
	int k = 0, t = 1;
	while (k != t)
	{
		k++;
		for (i = 0; i < 3; i++)
		{
			for (j = 0; j<3; j++)
			{
				if (i == j)
					continue;
				if ((i == 0 && j == 1) || (i == 1 && j == 0))
				{
					temp = 2;
				}
				else if ((i == 0 && j == 2) || (i == 2 && j == 0))
				{
					temp = 1;
				}
				else
				{
					temp = 0;
				}
				if (q[i][k] <= max[j] - q[j][k])
				{
					give[i] = 0;
					give[j] = q[i][k] + q[j][k];
					give[temp] = q[temp][k];
				}
				else
				{
					give[i] = q[i][k] + q[j][k] - max[j];
					give[j] = max[j];
					give[temp] = q[temp][k];
				}
				if (chk[give[0]][give[1]][give[2]] == 0)
				{
					t++;
					q[i][t] = give[i];
					q[j][t] = give[j];
					q[temp][t] = give[temp];
					if (give[0] == 0) ans[give[2]] = 1;
					chk[give[0]][give[1]][give[2]] = 1;
				}
			}
		}
	}
	for (i = 0; i <= 200; i++)
	{
		if (ans[i] == 1)
		{
			printf("%d ", i);
		}
	}
	return 0;
}*/
#include<stdio.h>
int visit[201][201], ans[201];
int wat_A, wat_B, wat_C;
void dfs(int, int, int);
int main()
{
	scanf("%d %d %d", &wat_A, &wat_B, &wat_C);
	dfs(0,0,wat_C);
	for (int i = 0; i < 201; i++) {
		if (ans[i]) {
			printf("%d ", i);
		}
	}
}
void dfs(int A, int B, int C)
{
	if (visit[A][B])
		return;
	if (A == 0)
		ans[C] = 1;
	visit[A][B] = 1;
	//A에서 B로 줄때
	if (A + B > wat_B) 
		dfs((A + B) - wat_B, wat_B, C);
	else 
		dfs(0, A + B, C);
	//B에서 A로 줄때
	if (B + A > wat_A)
		dfs(wat_A, (B + A) - wat_A, C);
	else 
		dfs(B + A, 0, C);
	//C에서 A로 줄때
	if (C + A > wat_A)
		dfs(wat_A, B, (C + A) - wat_A);
	else
		dfs(C + A, B, 0);
	//C에서 B로 줄때
	if (C + B > wat_B) 
		dfs(A, wat_B, (C + B) - wat_B);
	else 
		dfs(A, C+B, 0);
	//B에서 C로 A에서 C로
	//A+B = C 
	dfs(A, 0, B + C);
	dfs(0, B, A + C);
}

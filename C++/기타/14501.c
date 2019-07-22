#include<stdio.h>

int dp[16];

int main()
{
	int N;
	scanf("%d", &N);

	for (int i = 0; i < N; i++)
	{
		int Time, Pay;
		//N일까지 얻을 수 있는 이익을 담는다.
		scanf("%d %d", &Time, &Pay);
		if (dp[i] > dp[i + 1])
			dp[i + 1] = dp[i];
		if (dp[i + Time] < dp[i] + Pay)
			dp[i + Time] = dp[i] + Pay;
	}
	printf("%d\n", dp[N]);
	return 0;
}
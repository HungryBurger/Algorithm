#include<stdio.h>

int dp[16];

int main()
{
	int N;
	scanf("%d", &N);

	for (int i = 0; i < N; i++)
	{
		int Time, Pay;
		//N�ϱ��� ���� �� �ִ� ������ ��´�.
		scanf("%d %d", &Time, &Pay);
		if (dp[i] > dp[i + 1])
			dp[i + 1] = dp[i];
		if (dp[i + Time] < dp[i] + Pay)
			dp[i + Time] = dp[i] + Pay;
	}
	printf("%d\n", dp[N]);
	return 0;
}
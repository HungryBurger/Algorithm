#include<stdio.h>
void quickSort(int*, int, int);
int main()
{
	int N,day=1,answer=0;
	int t[100001];
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
		scanf("%d", &t[i]);
	quickSort(t, 0, N-1);
	
	for (int i = 1; i <= N; i++)
	{
		if (answer < day + t[N - i])
			answer = day + t[N - i];
		day++;
	}
	answer++;
	printf("%d \n",answer);
	return 0;
}
void quickSort(int *data, int start, int end)
{
	if (start >= end)
		return;
	int pivot = start;
	int i = pivot + 1;
	int j = end;
	int temp;

	while (i <= j) {
		while (i <= end && data[i] <= data[pivot]) {
			i++;
		}
		while (j > start&&data[j] >= data[pivot]) {
			j--;
		}
		if (i > j) {
			temp = data[j];
			data[j] = data[pivot];
			data[pivot] = temp;
		}
		else
		{
			temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}
	quickSort(data, start, j - 1);
	quickSort(data, j + 1, end);
}
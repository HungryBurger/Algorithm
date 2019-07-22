//BaekJoon 14487
//Developer : HyungjinJoo

#include<stdio.h>
#include<stdlib.h>
int maximum(int[], int);
int main()
{
	int n, i, idx, sum = 0;
	int* arr;

	scanf("%d", &n);

	if (n < 1 || n>50000)
	{
		printf("Error");
		return 0;
	}
	else
	{
		arr = (int*)malloc(sizeof(int)*n);
		for (i = 0; i < n; i++)
			scanf("%d", &arr[i]);
		idx = maximum(arr, n);

	}
	for (i = 0; i < n; i++)
	{
		if (i != idx)
			sum += arr[i];
	}
	printf("%d", sum);
}
int maximum(int a[], int n)
{
	int temp = 0, temp_idx;

	for (int i = 0; i < n; i++)
	{
		if (i == 0)
		{
			temp = a[i];
			temp_idx = i;
		}
		else if (temp < a[i])
		{
			temp = a[i];
			temp_idx = i;
		}
	}
	return temp_idx;
}
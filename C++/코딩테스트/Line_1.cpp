#include <iostream>
#include <cstdio>
long long int N;
void answer();
int w, h;
int main(void) {

	scanf("%d", &N);
	if (N >= 1 && N <= 10000000000000)
	{
		answer();
	}
	return 0;
}
void answer() {
	int count = 0;
	int arr[197] = { 0, };
	for (int i = 1; i <= N; i++) {
		if (N%i == 0) {
			arr[count] = i;
			count++;
		}
	}
	if (count % 2 == 1)
		printf("0");
	else
	{
		w = count / 2 - 1;
		h = count / 2;
		printf("%ld", labs(arr[w] - arr[h]));
	}
}

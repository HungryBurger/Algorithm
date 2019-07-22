#include<stdio.h>
int main()
{
	int bin[101] = { 0, },answer, n, T;
	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		answer = 0;
		scanf("%d", &n);
		for (int a = 1; a <= n ; a++) {
			for (int b = a; b <= n; b+=a) {
				bin[b] = !bin[b];
			}
		}
		for (int a = 1; a <=n; a++) {
			answer+=bin[a];
			bin[a] = 0;
		}
		printf("%d\n", answer);
	}
	return 0;
}
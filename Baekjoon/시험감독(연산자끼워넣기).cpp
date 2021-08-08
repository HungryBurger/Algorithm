#include<cstdio>
long long minResult();
long long N, A[1000000], B, C;
int main() {
	scanf("%lld", &N);
	for (int i = 0; i < N; i++) {
		scanf("%lld", &A[i]);
	}
	scanf("%lld %lld", &B, &C);

	printf("%lld", minResult());

	return 0;
}
long long minResult() {
	long long result = 0;
	for (int i = 0; i < N; i++) {
		long long temp = A[i] - B;
		if (temp <= 0)
			result += 1;
		else {
			if ((temp % C) == 0)
				result += 1 + temp / C;
			else {
				result += 1 + 1 + temp / C;
			}
		}
	}
	return result;
}
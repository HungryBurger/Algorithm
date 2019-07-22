//baekjoon 1213
//Developer : HyungjinJoo
#include<stdio.h>
#include<stdlib.h>
int main()
{
	int i, k, t, temp, count, count1 = 0, check = -1, check1 = 0;
	int alpha[26] = { 0, };
	char sentence[51] = { 0, }, sen[51] = { 0, };

	gets(sentence);
	//소문자 걸러주기
	for (i = 0; i < strlen(sentence); i++) {
		temp = sentence[i] - 'A';
		if (temp < 0 || temp>25)
		{
			printf("I'm Sorry Hansoo");
			return 0;
		}
		//알파벳 갯수증가
		alpha[temp]++;
	}

	for (i = 0; i < 26; i++) {
		if (alpha[i] % 2 == 1) {
			check = i;
			count1++;
		}
	}
	//예외상황 처리
	if (count1 != 0 && count1 != 1) {
		printf("I'm Sorry Hansoo");
		return 0;
	}

	else {
		for (i = 0; i < strlen(sentence) / 2; i++) {
			for (t = 0; t < 26; t++) {
				if (alpha[t] != 0)
				{
					for (k = 0; k < alpha[t] / 2; k++)
					{
						sen[i] = 'A' + t;
						i++;
					}
				}
			}
		}
		//홀수개가 하나도 존재하지 않을 경우
		if (check == -1) {
			i = strlen(sentence) / 2;
			for (t = 25; t >= 0; t--) {
				if (alpha[t] != 0)
				{
					for (k = 0; k < alpha[t] / 2; k++) {
						sen[i] = 'A' + t;
						i++;
					}
				}
			}
		}
		//홀수개가 하나 존재했을때
		else {
			sen[(strlen(sentence) - 1) / 2] = 'A' + check;
			i = strlen(sentence) / 2 + 1;
			for (t = 25; t >= 0; t--) {
				if (alpha[t] != 0)
				{
					for (k = 0; k < alpha[t] / 2; k++) {
						sen[i] = 'A' + t;
						i++;
					}
				}
			}
		}
		puts(sen);
	}
	return 0;
}
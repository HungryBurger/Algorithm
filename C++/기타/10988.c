//Baekjoon 10988
//Developer : Hyungjin Joo
#include<stdio.h>
int main()
{
	char str[100];
	int length, rev, i, check = 1;
	scanf("%s", &str);
	length = strlen(str);
	rev = length - 1;
	for (i = 0; i < length / 2; i++)
	{
		if (str[i] != str[rev--])
		{
			check = 0;
			break;
		}
	}
	printf("%d", check);

	return 0;
}
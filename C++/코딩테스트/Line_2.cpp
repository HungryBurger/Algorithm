#include <iostream>
#include <cstdio>
#include	<string>
#include<cstring>
using namespace std;
char str[100] = "";
char answer[100] = "";
int Factory()
{
	int ch_count = 0, num_count = 0, ans_count = 0;
	int big = 0, num_ch = 0;
	char character[100] = "";
	char num[100] = "";
	for (int i = 0; i < sizeof(str); i++) {
		if ((str[i] >= 'A' && str[i] <= 'Z') || (str[i] >= 'a'&&str[i] <= 'z')) {
			character[ch_count] = str[i];
			ch_count++;
		}
		if (str[i] >= 'A' && str[i] <= 'Z')
			big++;
		if ((str[i] >= '0'&&str[i] <= '9')) {
			num[num_count] = str[i];
			num_count++;
		}
		if (str[i] >= '1'&&str[i] <= '9')
		{
			num_ch++;
		}
	}
	if (num_ch != big)
		return -1;
	num_count = 0;
	ans_count = 0;

	for (int i = 0; i < strlen(character); i++) {
		if (character[i] >= 'A' && character[i] <= 'Z') {

			answer[ans_count] = character[i];
			ans_count++;
			if (character[i + 1]<'a' || character[i]>'z') {
				if ((i + 1) < strlen(character)) {
					if (character[i + 1] >= 'A' && character[i + 1] <= 'Z') {
						if (num[num_count] != '1')
						{
							answer[ans_count] = num[num_count];
							ans_count++;
							num_count++;
						}
						else if (num[num_count] == '1') {
							if (num_count + 1 < strlen(num)) {
								if (num[num_count + 1] == '0')
								{
									answer[ans_count] = num[num_count];
									ans_count++;
									num_count++;
									answer[ans_count] = '0';
									ans_count++;
									num_count++;
								}
								else {
									num_count++;
								}
							}
						}
					}
				}
				else if ((i + 1) == strlen(character)) {
					if (num[num_count] != '1')
					{
						answer[ans_count] = num[num_count];
						ans_count++;
						num_count++;
					}
					else if (num[num_count] == '1') {
						if (num_count < strlen(num)) {
							if (num[num_count + 1] == '0')
							{
								answer[ans_count] = num[num_count];
								ans_count++;
								num_count++;
								answer[ans_count] = '0';
								ans_count++;
								num_count++;
							}
							else
							{
								num_count++;
							}
						}
					}
				}
			}
		}
		else if (character[i] >= 'a' && character[i] <= 'z')
		{
			answer[ans_count] = character[i];
			ans_count++;
			if (num[num_count] != '1')
			{
				answer[ans_count] = num[num_count];
				ans_count++;
				num_count++;
			}
			else if (num[num_count] == '1') {
				if (num_count < strlen(num)) {
					if (num[num_count + 1] == '0')
					{
						answer[ans_count] = num[num_count];
						ans_count++;
						num_count++;
						answer[ans_count] = '0';
						ans_count++;
						num_count++;
					}
				}
			}
		}
	}
	return 0;
}
int main(void) {
	cin >> str;
	int temp = Factory();
	if (temp == -1)
		cout << "error" << endl;
	else
		cout << answer;
	return 0;
}
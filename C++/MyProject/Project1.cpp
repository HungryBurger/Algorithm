#include<iostream>
#define MAX 9000000
int** basicData;
int** randData;
int** jackPot;
void initSetting();
int duplicateNum(); //compare with Basic Data
int sameName(); //Compare with Lucky Data
int continulyData(); //Delete with continus Data at least 3

int main()
{

	initSetting();
	//DataInput
	while (1) {

	}
	//Sort ascending


	//Verification
	int ver1 = duplicateNum();
	int ver2 = sameName();
	int ver3 = continulyData();

	//Jackpot에 데이터 삽입
	if (ver1 == 1 && ver2 == 1 && ver3 == 1) {

	}
	



	return 0;
}
void initSetting() {
	basicData = new int* [10000];
	randData = new int* [MAX];
	jackPot = new int* [MAX];
	for (int i = 0; i < MAX; i++) {
		randData[i] = new int[7];
		jackPot[i] = new int[7];
	}
	for (int i = 0; i < 10000; i++) {
		basicData[i] = new int[7];
	}
}
int duplicateNum() {

}
int sameName() {

}
int continulyData() {

}
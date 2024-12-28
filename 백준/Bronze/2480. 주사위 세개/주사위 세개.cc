#include <iostream>
using namespace std;

int main(int argc, char const* argv[]) {
	int dice[7] = { 0 };
	int number[3] = { 0 };
	cin >> number[0] >> number[1] >> number[2];

	dice[number[0]]++;
	dice[number[1]]++;
	dice[number[2]]++;
	int result = 0;
	int maxV = 0;
	for (int i = 1; i <= 6; i++) {
		if (dice[i] == 3) {
			result = 10000 + i * 1000;
			break;
		}
		if (dice[i] == 2) {
			result = 1000 + i * 100;
			break;
		}
		if (dice[i] == 1) {
			maxV = i;
		}
	}
	if(result==0) result=maxV * 100;
	cout << result;
	return 0;
}
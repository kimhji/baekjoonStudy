#include <iostream>
#include <string>
#include <algorithm>
#define FASTIO ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
using namespace std;
 
int main() {
    FASTIO
    
    string input_string;
    cin >> input_string;
 
    int start_num = 0;                              // 시작 정수
    int range = min(3, (int)input_string.length()); // 시작 정수의 최대 자릿수
 
    for (int i = 0; i < range; i++) {
        start_num = start_num * 10 + input_string[i] - '0';
        string adding_string;
 
        for (int next_num = start_num; ; next_num++) {
            adding_string += to_string(next_num);
 
            if (adding_string == input_string) {
                cout << start_num << " " << next_num;
                return 0;
            }
            
            if (adding_string.size() > input_string.size())
                break;
        }
        
    }
 
    return 0;
}
#include <iostream>
#include <string>
using namespace std;

// 키보드 행 정의
string str[4] = { 
    "`1234567890-=", 
    "QWERTYUIOP[]\\", 
    "ASDFGHJKL;'", 
    "ZXCVBNM,./" 
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string s;
    // 여러 줄 입력 처리
    while (getline(cin, s)) {
        for (int t = 0; t < s.size(); t++) {
            if (s[t] == ' ') {
                // 공백은 그대로 출력
                cout << s[t];
                continue;
            }

            // 문자의 바로 왼쪽 문자 찾기
            bool found = false;
            for (int i = 0; i < 4; i++) { // 각 행 탐색
                for (int j = 0; j < str[i].size(); j++) {
                    if (s[t] == str[i][j]) {
                        cout << str[i][j - 1]; // 바로 왼쪽 문자 출력
                        found = true;
                        break;
                    }
                }
                if (found) break; // 문자를 찾으면 더 이상 탐색하지 않음
            }
        }
        cout << '\n'; // 한 줄 처리 후 개행
    }

    return 0;
}
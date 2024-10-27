const fs = require("fs");

// 입력 읽기
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [n, k] = input[0].split(" ").map(Number);

// 물건 배열 초기화
const thing = [[0, 0]];
for (let i = 1; i <= n; i++) {
    const [weight, value] = input[i].split(" ").map(Number);
    thing.push([weight, value]);
}

// dp 배열 초기화
const d = Array.from({ length: n + 1 }, () => Array(k + 1).fill(0));

// 동적 프로그래밍
for (let i = 1; i <= n; i++) {
    const w = thing[i][0];
    const v = thing[i][1];

    for (let j = 1; j <= k; j++) {
        if (j < w) {
            d[i][j] = d[i - 1][j];
        } else {
            d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - w] + v);
        }
    }
}

// 결과 출력
console.log(d[n][k]);

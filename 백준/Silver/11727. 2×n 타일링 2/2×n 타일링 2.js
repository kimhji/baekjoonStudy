function tile2n(n) {
  const dp = new Array(n + 1).fill(0);

  // 기저 사례
  dp[0] = 1; // 0 크기 직사각형을 채우는 방법은 1가지
  dp[1] = 1; // 2x1 타일 하나
  dp[2] = 3; // 2x2 타일을 놓는 방법 3가지

  for (let i = 3; i <= n; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007; // 수정된 점화식
  }

  return dp[n];
}

const fs = require("fs");
//const n = parseInt(fs.readFileSync("input.txt").toString().trim());
const n = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
const value = tile2n(n);
console.log(value);

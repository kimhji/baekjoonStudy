function solution(N) {
  const dp = new Array(N + 1).fill(Infinity); 
  dp[0] = 0; 

  for (let i = 1; i <= N; i++) {
    if (i >= 3) {
      dp[i] = Math.min(dp[i], dp[i - 3] + 1);
    }
    if (i >= 5) {
      dp[i] = Math.min(dp[i], dp[i - 5] + 1);
    }
  }

  return dp[N] === Infinity ? -1 : dp[N];
}

const fs = require("fs");
// const N = parseInt(fs.readFileSync("input.txt").toString().trim());
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());

console.log(solution(N));

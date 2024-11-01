function gcd(x, y) {
  if (y === 0) return x;
  return gcd(y, x % y);
}

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const T = parseInt(inp[0].trim());
for (let caseIdx = 1; caseIdx <= T; caseIdx++) {
  const [A, B, X] = inp[caseIdx].trim().split(" ").map(Number);
  console.log(Math.floor(X / gcd(A, B)));
}

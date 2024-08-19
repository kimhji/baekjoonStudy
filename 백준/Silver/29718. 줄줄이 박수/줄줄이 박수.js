const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const [N, M] = inp[0].trim().split(" ").map(Number);
const cols = new Array(M).fill(0);
for (let check = 1; check <= N; check++) {
  let line = inp[check].trim().split(" ").map(Number);
  for (let sum = 0; sum < M; sum++) {
    cols[sum] += line[sum];
  }
}
const A = parseInt(inp[N + 1]);
let result = 0;
for (let cycle = 0; cycle <= M - A; cycle++) {
  let s = 0;
  for (let sum = 0; sum < A; sum++) {
    s += cols[cycle + sum];
  }
  if (result < s) result = s;
}
console.log(result);

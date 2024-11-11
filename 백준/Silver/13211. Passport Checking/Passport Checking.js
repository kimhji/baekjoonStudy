const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
const stolenStuff = new Map();
for (let idx = 1; idx <= N; idx++) {
  stolenStuff.set(inp[idx].trim(), true);
}
const M = parseInt(inp[N + 1].trim());
let result = 0;
for (let idx = 1; idx <= M; idx++) {
  const passport = inp[idx + N + 1].trim();
  if (stolenStuff.get(passport)) {
    result += 1;
  }
}
console.log(result);

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
let numbers = [];
for (let idx = 1; idx <= N; idx++) {
  numbers.push(parseInt(inp[idx].trim()));
}
numbers.sort((a, b) => {
  return b - a;
});
let result = 0;
let minV = Infinity;
for (let idx = 0; idx < N; idx++) {
  const nextMinV = Math.min(numbers[idx], minV);
  const nextResult = nextMinV * (idx + 1);
  if (nextResult > result) {
    result = nextResult;
    minV = nextMinV;
  }
}
console.log(result);

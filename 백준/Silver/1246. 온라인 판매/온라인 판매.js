const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const [N, M] = inp[0].trim().split(" ").map(Number);
const values = [];
for (let cycle = 1; cycle <= M; cycle++) {
  values.push(parseInt(inp[cycle].trim()));
}
values.sort((a, b) => {
  return b - a;
});
let maxV = 0;
let totalV = 0;
for (let check = 0; check < M; check++) {
  const num = check + 1 < N ? check + 1 : N;
  const curVal = num * values[check];
  if (totalV < curVal || (totalV === curVal && maxV > values[check])) {
    maxV = values[check];
    totalV = curVal;
  }
}
console.log(maxV, totalV);

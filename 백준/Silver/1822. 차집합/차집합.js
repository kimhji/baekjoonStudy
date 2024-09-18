const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, M] = inp[0].trim().split(" ").map(Number);
const A = inp[1].trim().split(" ").map(Number);
const B = new Set(inp[2].trim().split(" ").map(Number));

const result = A.filter((aData) => {
  return !B.has(aData);
});
result.sort((a, b) => {
  return a - b;
});
const l = result.length;
console.log(l);
if (l) console.log(result.join(" "));

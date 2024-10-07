const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const target = inp[0].trim();
let numOfRing = parseInt(inp[1].trim());
let result = 0;
for (let cycle = 2; cycle <= numOfRing + 1; cycle++) {
  const curRing = inp[cycle].trim() + inp[cycle].trim();
  if (curRing.includes(target)) result++;
}
console.log(result);

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const n = parseInt(inp[0].trim());
const tips = [];
for (let cycle = 1; cycle <= n; cycle++) {
  tips.push(parseInt(inp[cycle].trim()));
}
tips.sort((a, b) => {
  return b - a;
});

let order = 0;
let result = 0;
tips.forEach((tip) => {
  const curTip = tip - order++;
  if (curTip > 0) result += curTip;
});
console.log(result);

const reg = new RegExp(/^(100+1+|01)+$/);
const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0]);
for (let inpCycle = 1; inpCycle <= N; inpCycle++) {
  reg.exec(inp[inpCycle].trim()) ? console.log("YES") : console.log("NO");
}

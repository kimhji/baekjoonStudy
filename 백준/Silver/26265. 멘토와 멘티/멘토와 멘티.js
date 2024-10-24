const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
const arr = [];
for (let cycle = 1; cycle <= N; cycle++) {
  arr.push(inp[cycle].trim().split(" "));
}

arr.sort((a, b) => {
  if (a[0] < b[0]) return -1;
  else if (a[0] > b[0]) return 1;
  else {
    if (a[1] < b[1]) return 1;
    else return -1;
  }
});
arr.forEach((pair) => {
  console.log(pair.join(" "));
});
